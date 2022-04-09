package com.bcorp.polaris.storefront.service.strategy.impl;

import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.constant.CartLineItemInvalidType;
import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;
import com.bcorp.polaris.storefront.dto.error.CartLineItemError;
import com.bcorp.polaris.storefront.service.BookService;
import com.bcorp.polaris.storefront.service.CartService;
import com.bcorp.polaris.storefront.service.strategy.CartValidationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "cartValidationStrategy")
public class DefaultCartValidationStrategy implements CartValidationStrategy
{
    private BookService bookService;
    private CartService cartService;

    @Autowired
    public DefaultCartValidationStrategy(BookService bookService, CartService cartService)
    {
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @Override
    public void validateCart(CommerceCartParameter parameter)
    {
//        final CartBo cartBo = parameter.getCartBo();
//        validateParameterNotNullStandardMessage("CartBo", cartBo);
//
//        final List<CartLineItemRecord> lineItems = cartBo.getLineItems();
//
//        List<CartLineItemError> cartLineItemErrors = new ArrayList<>();
//
//        if (cartBo.getCart() != null && lineItems != null && !lineItems.isEmpty())
//        {
//            for (final CartLineItemRecord lineItem : lineItems)
//            {
//                final CartLineItemError error = validateCartLineItem(lineItem);
//                if (error != null)
//                {
//                    cartLineItemErrors.add(error);
//                }
//            }
//        }

//        if (CollectionUtils.isNotEmpty(cartLineItemErrors))
//        {
//            throw new PolarisServerRuntimeException(InternalErrorCode.CART_CHECKOUT_ERROR, "", Collections.singletonList(cartLineItemErrors));
//        }
    }

    private CartLineItemError validateCartLineItem(CartLineItemRecord cartLineItemRecord)
    {
        // First verify that the product exists
        BookRecord bookRecord;
        try
        {
            bookRecord = bookService.getBookForId(cartLineItemRecord.getBookId());
        }
        catch (PolarisServerRuntimeException ex)
        {
            CartLineItemError error = new CartLineItemError();
            error.setLineItemId(cartLineItemRecord.getId());
            error.setBookId(cartLineItemRecord.getBookId());
            error.setInvalidType(CartLineItemInvalidType.BOOK_UNAVAILABLE);
            error.setErrorMessage("The book is unpublished");
            return error;
        }

        // Second verify if book price has changed
        final BookBo bookBo = bookService.getBookBo(bookRecord);
        if (!bookBo.getKey().equals(cartLineItemRecord.getItemKey()))
        {
            CartLineItemError error = new CartLineItemError();
            error.setLineItemId(cartLineItemRecord.getId());
            error.setBookId(cartLineItemRecord.getBookId());
            error.setInvalidType(CartLineItemInvalidType.BOOK_INFO_HAS_CHANGED);
            error.setErrorMessage("The book information in the cart has been modified");
            return error;
        }

        return null;
    }
}
