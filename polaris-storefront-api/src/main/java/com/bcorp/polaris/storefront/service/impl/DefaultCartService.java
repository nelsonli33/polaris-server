package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.constant.CartLineItemStatus;
import com.bcorp.polaris.storefront.dao.CartDao;
import com.bcorp.polaris.storefront.service.*;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.bcorp.polaris.core.model.tables.CartLineItem.CART_LINE_ITEM;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;
import static java.util.Collections.emptyList;

@Service(value = "cartService")
public class DefaultCartService implements CartService
{
    private UserService userService;
    private BookService bookService;
    private CalculationService calculationService;
    private CartFactory cartFactory;
    private CartDao cartDao;
    private DSLContext dslContext;


    public DefaultCartService(UserService userService,
                              BookService bookService,
                              CalculationService calculationService,
                              CartFactory cartFactory,
                              CartDao cartDao,
                              DSLContext dslContext)
    {
        this.userService = userService;
        this.bookService = bookService;
        this.calculationService = calculationService;
        this.cartFactory = cartFactory;
        this.cartDao = cartDao;
        this.dslContext = dslContext;
    }

    @Override
    public CartRecord getCartForCurrentUser()
    {
        final UserRecord currentUser = userService.getCurrentUser();
        final CartRecord cart = cartDao.findCartByUser(currentUser);

        if (cart != null)
        {
            return cart;
        }
        else
        {
            return cartFactory.createCart();
        }
    }


    @Override
    @Transactional
    public CartBo getCartDetailForCurrentUser()
    {
        // 1. get cart and line items for current user
        final CartBo cartBo = getCartBo();

        // 2. check book info (price, name, status) if changed, then refresh cart line items
        boolean hasAnyRecordUpdated = updateCartLineItemIfNeeded(cartBo);

        // 3. if any record has been updated, recalculate cart
        if (hasAnyRecordUpdated)
        {
            calculationService.calculate(cartBo);
        }
        return cartBo;
    }

    protected boolean updateCartLineItemIfNeeded(CartBo cartBo)
    {
        boolean hasAnyRecordUpdated = false;

        final Iterator<CartLineItemRecord> iterator = cartBo.getLineItems().iterator();
        while (iterator.hasNext())
        {
            final CartLineItemRecord lineItem = iterator.next();

            // remove cartLineItem if book has unpublished
            BookRecord bookRecord = null;
            try
            {
                bookRecord = bookService.getBookForId(lineItem.getBookId());
            }
            catch (PolarisServerRuntimeException ex)
            {
                lineItem.delete();
                iterator.remove();
                hasAnyRecordUpdated = true;
            }


            // update cartLineItem name, price if book name and price has changed
            if (bookRecord != null)
            {
                final BookBo bookBo = bookService.getBookBo(bookRecord);
                if (!lineItem.getItemKey().equals(bookBo.getKey()))
                {
                    lineItem.setName(bookBo.getTitle());
                    lineItem.setPrice(bookBo.getPrice());
                    lineItem.setItemKey(bookBo.getKey());
                    lineItem.update();
                    hasAnyRecordUpdated = true;
                }
            }
        }
        return hasAnyRecordUpdated;
    }

    public CartBo getCartBo()
    {
        final UserRecord currentUser = userService.getCurrentUser();
        if (!hasCart())
        {
            CartBo cartBo = new CartBo();
            cartBo.setCart(cartFactory.createCart());
            cartBo.setLineItems(emptyList());
            return cartBo;
        }
        else
        {
            final Map<CartRecord, List<CartLineItemRecord>> recordMap
                    = cartDao.findCartAndLineItemsByUser(currentUser);

            return recordMap.entrySet().stream().map(e -> {
                CartBo cartBo = new CartBo();
                cartBo.setCart(e.getKey());
                cartBo.setLineItems(e.getValue());
                return cartBo;
            }).findFirst().orElse(new CartBo());
        }
    }

    @Override
    public boolean hasCart()
    {
        final UserRecord currentUser = userService.getCurrentUser();
        return cartDao.checkUserIfHasCart(currentUser);
    }


    @Override
    public CartLineItemRecord addCartLineItem(CartBo cartBo, BookBo bookBo)
    {
        validateParameterNotNullStandardMessage("CartBo", cartBo);
        validateParameterNotNullStandardMessage("bookBo", bookBo);

        // cart line item exists -> book info changed update or return directly
        final Optional<CartLineItemRecord> cartLineItem = getCartLineItemForBook(cartBo, bookBo);
        if (cartLineItem.isPresent() && !checkIfBookPropertyChanged(cartLineItem.get(), bookBo))
        {
            return cartLineItem.get();
        }

        if (cartLineItem.isPresent() && checkIfBookPropertyChanged(cartLineItem.get(), bookBo))
        {
            updateCartLineItemInfoForBook(cartLineItem.get(), bookBo);
            return cartLineItem.get();
        }

        // cart line item not exists -> create one
        CartLineItemRecord newCartLineItemRecord = dslContext.newRecord(CART_LINE_ITEM);
        newCartLineItemRecord.setCartId(cartBo.getCart().getId());
        newCartLineItemRecord.setBookId(bookBo.getBookId());
        newCartLineItemRecord.setName(bookBo.getTitle());
        newCartLineItemRecord.setPrice(bookBo.getPrice());
        newCartLineItemRecord.setStatus((byte) CartLineItemStatus.PUBLISHED.getValue());
        newCartLineItemRecord.store();
        cartBo.getLineItems().add(newCartLineItemRecord);
        return newCartLineItemRecord;
    }

    private boolean checkIfBookPropertyChanged(CartLineItemRecord cartLineItem, BookBo bookBo)
    {
        return cartLineItem.getItemKey().equals(bookBo.getKey());
    }

    @Override
    public Optional<CartLineItemRecord> getCartLineItemForBook(CartBo cartBo, BookBo bookBo)
    {
        validateParameterNotNullStandardMessage("cartBo", cartBo);
        validateParameterNotNullStandardMessage("bookBo", bookBo);

        final List<CartLineItemRecord> lineItems = cartBo.getLineItems();
        if (lineItems == null || lineItems.isEmpty() || bookBo.getBookId() == null)
        {
            return Optional.empty();
        }

        for (final CartLineItemRecord lineItem : lineItems)
        {
            if (lineItem.getBookId().equals(bookBo.getBookId()))
            {
                return Optional.of(lineItem);
            }
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void removeCart()
    {
        final CartRecord cart = getCartForCurrentUser();
        removeAllCartLineItems(cart);
        cart.delete();
    }


    @Override
    public void removeAllCartLineItems(CartRecord cartRecord)
    {
        validateParameterNotNullStandardMessage("cartRecord", cartRecord);
        cartDao.deleteAllCartItemsByCart(cartRecord);
    }


    private boolean updateCartLineItemInfoForBook(CartLineItemRecord lineItem, BookBo bookBo)
    {
        validateParameterNotNullStandardMessage("lineItem", lineItem);
        validateParameterNotNullStandardMessage("bookBo", bookBo);

        boolean updated = false;

        if (!lineItem.getItemKey().equals(bookBo.getKey()))
        {
            lineItem.setName(bookBo.getTitle());
            lineItem.setPrice(bookBo.getPrice());
            lineItem.setItemKey(bookBo.getKey());
            lineItem.update();
            updated = true;
        }

        return updated;
    }
}
