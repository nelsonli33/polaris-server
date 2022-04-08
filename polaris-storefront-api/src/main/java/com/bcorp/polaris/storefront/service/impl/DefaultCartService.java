package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dao.CartDao;
import com.bcorp.polaris.storefront.service.CartFactory;
import com.bcorp.polaris.storefront.service.CartService;
import com.bcorp.polaris.storefront.service.UserService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.bcorp.polaris.core.model.tables.CartLineItem.CART_LINE_ITEM;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Service(value = "cartService")
public class DefaultCartService implements CartService
{
    private UserService userService;
    private CartFactory cartFactory;
    private CartDao cartDao;
    private DSLContext dslContext;


    public DefaultCartService(UserService userService,
                              CartFactory cartFactory,
                              CartDao cartDao,
                              DSLContext dslContext)
    {
        this.userService = userService;
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
    public Map<CartRecord, List<CartLineItemRecord>> getCartDetailForCurrentUser()
    {
        final UserRecord currentUser = userService.getCurrentUser();
        if (!cartDao.checkUserIfHasCart(currentUser))
        {
            cartFactory.createCart();
        }
        return cartDao.findCartAndLineItemsByUser(currentUser);
    }


    @Override
    public CartLineItemRecord addCartLineItem(CartRecord cartRecord, BookRecord bookRecord)
    {
        validateParameterNotNullStandardMessage("cartRecord", cartRecord);
        validateParameterNotNullStandardMessage("bookRecord", bookRecord);

        final Optional<CartLineItemRecord> cartLineItem = getCartLineItem(cartRecord, bookRecord);
        if (cartLineItem.isPresent())
        {
            return cartLineItem.get();
        }
        else
        {
            CartLineItemRecord newCartLineItemRecord = dslContext.newRecord(CART_LINE_ITEM);
            newCartLineItemRecord.setCartId(cartRecord.getId());
            newCartLineItemRecord.setBookId(bookRecord.getId());
            newCartLineItemRecord.setName(bookRecord.getTitle());
            newCartLineItemRecord.setPrice(bookRecord.getPrice());
            newCartLineItemRecord.store();
            return newCartLineItemRecord;
        }
    }

    @Override
    public Optional<CartLineItemRecord> getCartLineItem(CartRecord cartRecord, BookRecord bookRecord)
    {
        validateParameterNotNullStandardMessage("cartRecord", cartRecord);
        validateParameterNotNullStandardMessage("bookRecord", bookRecord);
        return Optional.ofNullable(cartDao.findCartLineItemByCartAndBook(cartRecord, bookRecord));
    }

    @Override
    public List<CartLineItemRecord> getAllCartLineItemsForCart(CartRecord cartRecord)
    {
        validateParameterNotNullStandardMessage("cartRecord", cartRecord);
        return cartDao.findAllCartLineItemsByCart(cartRecord);
    }

    @Override
    public void removeAllCartLineItems(CartRecord cartRecord)
    {
        validateParameterNotNullStandardMessage("cartRecord", cartRecord);
        cartDao.deleteAllCartItemsByCart(cartRecord);
    }
}
