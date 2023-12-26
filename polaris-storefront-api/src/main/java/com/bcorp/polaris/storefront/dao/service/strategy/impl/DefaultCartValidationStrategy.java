package com.bcorp.polaris.storefront.dao.service.strategy.impl;

import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.constant.CartLineItemInvalidType;
import com.bcorp.polaris.storefront.dao.service.BookService;
import com.bcorp.polaris.storefront.dao.service.CartService;
import com.bcorp.polaris.storefront.dao.service.strategy.CartValidationStrategy;
import com.bcorp.polaris.storefront.dto.CommerceCartParameter;
import com.bcorp.polaris.storefront.dto.error.CartLineItemError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Slf4j
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
    public boolean validateCartIsValid(CommerceCartParameter parameter)
    {
        final CartBo cartBo = parameter.getCartBo();
        validateParameterNotNullStandardMessage("CartBo", cartBo);

        final List<CartLineItemRecord> lineItems = cartBo.getLineItems();

        if (cartBo.getCart() != null && lineItems != null && !lineItems.isEmpty())
        {
            for (final CartLineItemRecord lineItem : lineItems)
            {
                final CartLineItemError error = validateCartLineItem(lineItem);
                if (error != null)
                {
                    log.info(error.toString());
                    return false;
                }
            }
        }

        return true;
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

        // Second verify if book name, price has changed
        if (bookRecord != null)
        {
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
        }
        return null;
    }
}
