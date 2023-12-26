package com.bcorp.polaris.storefront.dao.service.strategy.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.dao.service.strategy.AddToCartStrategy;
import com.bcorp.polaris.storefront.dto.CommerceCartParameter;
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

        final CartBo cartBo = parameter.getCartBo();
        final BookBo bookBo = parameter.getBookBo();

        getCartService().addCartLineItem(cartBo, bookBo);
    }

    protected void validateAddToCart(CommerceCartParameter parameter)
    {
        final CartBo cartBo = parameter.getCartBo();
        final BookBo bookBo = parameter.getBookBo();
        validateParameterNotNull(cartBo, "CartBo cannot be null");
        validateParameterNotNull(bookBo, "BookBo cannot be null");

        final CartRecord cart = cartBo.getCart();
        final BookRecord book = bookBo.getBook();
        validateParameterNotNull(bookBo, "CartRecord cannot be null");
        validateParameterNotNull(bookBo, "BookRecord cannot be null");

        if (cart.getUserId().equals(book.getUserId()))
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.ADD_TO_CART_ERROR, "Cart owner and book author are same person." +
                    " Author cannot buy own book.");
        }
    }
}
