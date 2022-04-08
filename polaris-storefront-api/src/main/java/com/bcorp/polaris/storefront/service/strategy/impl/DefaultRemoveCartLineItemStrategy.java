package com.bcorp.polaris.storefront.service.strategy.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;
import com.bcorp.polaris.storefront.service.strategy.RemoveCartLineItemStrategy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component(value = "removeCartLineItemStrategy")
public class DefaultRemoveCartLineItemStrategy extends AbstractCartStrategy
        implements RemoveCartLineItemStrategy
{
    @Override
    @Transactional
    public void removeLineItem(CommerceCartParameter parameter)
    {
        final CartRecord cart = parameter.getCart();
        final BookRecord book = parameter.getBook();

        final Optional<CartLineItemRecord> cartLineItem
                = getCartService().getCartLineItem(cart, book);

        if (cartLineItem.isEmpty())
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.REMOVE_CART_LINE_ITEM_ERROR, "lineItem not found in exists cart");
        }

        cartLineItem.get().delete();
        getCartCalculationStrategy().calculateCart(parameter);
    }

    @Override
    @Transactional
    public void removeAllLineItems(CommerceCartParameter parameter)
    {
        final CartRecord cart = parameter.getCart();
        getCartService().removeAllCartLineItems(cart);
        getCartCalculationStrategy().calculateCart(parameter);
    }
}
