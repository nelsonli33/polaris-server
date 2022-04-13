package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.storefront.dto.CommerceCartParameter;
import com.bcorp.polaris.storefront.service.CommerceCartService;
import com.bcorp.polaris.storefront.service.strategy.AddToCartStrategy;
import com.bcorp.polaris.storefront.service.strategy.CartValidationStrategy;
import com.bcorp.polaris.storefront.service.strategy.RemoveCartLineItemStrategy;
import org.springframework.stereotype.Service;

@Service(value = "commerceCartService")
public class DefaultCommerceCartService implements CommerceCartService
{
    private AddToCartStrategy addToCartStrategy;
    private RemoveCartLineItemStrategy removeCartLineItemStrategy;
    private CartValidationStrategy cartValidationStrategy;

    public DefaultCommerceCartService(AddToCartStrategy addToCartStrategy,
                                      RemoveCartLineItemStrategy removeCartLineItemStrategy,
                                      CartValidationStrategy cartValidationStrategy)
    {
        this.addToCartStrategy = addToCartStrategy;
        this.removeCartLineItemStrategy = removeCartLineItemStrategy;
        this.cartValidationStrategy = cartValidationStrategy;
    }

    @Override
    public void addToCart(CommerceCartParameter parameter)
    {
        addToCartStrategy.addToCart(parameter);
    }

    @Override
    public void removeCartLineItem(CommerceCartParameter parameter)
    {
        removeCartLineItemStrategy.removeLineItem(parameter);
    }

    @Override
    public void removeAllCartLineItems(CommerceCartParameter parameter)
    {
        removeCartLineItemStrategy.removeAllLineItems(parameter);
    }

    @Override
    public boolean validateCartIsValid(CommerceCartParameter parameter)
    {
        return cartValidationStrategy.validateCartIsValid(parameter);
    }
}
