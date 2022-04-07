package com.bcorp.polaris.storefront.service.strategy.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;
import com.bcorp.polaris.storefront.service.strategy.AddToCartStrategy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Component(value = "addToCartStrategy")
public class DefaultAddToCartStrategy extends AbstractCartStrategy implements AddToCartStrategy
{
    @Override
    @Transactional
    public void addToCart(CommerceCartParameter parameter)
    {
        doAddToCart(parameter);
        getCartCalculationStrategy().calculateCart(parameter);
    }

    protected void doAddToCart(CommerceCartParameter parameter)
    {
        validateAddToCart(parameter);

        final CartRecord cart = parameter.getCart();
        final BookRecord book = parameter.getBook();

        getCartService().addCartLineItem(cart, book);
    }

    protected void validateAddToCart(CommerceCartParameter parameter)
    {
        final CartRecord cart = parameter.getCart();
        final BookRecord book = parameter.getBook();

        validateParameterNotNull(cart, "CartRecord cannot be null");
        validateParameterNotNull(book, "BookRecord cannot be null");

        if (cart.getUserId().equals(book.getUserId()))
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.ADD_TO_CART_ERROR, "Cart owner and book author are same person." +
                    " Author cannot buy own book.");
        }
    }
}
