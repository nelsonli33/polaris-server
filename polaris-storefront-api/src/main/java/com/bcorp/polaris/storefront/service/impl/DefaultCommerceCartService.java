package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;
import com.bcorp.polaris.storefront.service.CommerceCartService;
import com.bcorp.polaris.storefront.service.strategy.AddToCartStrategy;
import org.springframework.stereotype.Service;

@Service(value = "commerceCartService")
public class DefaultCommerceCartService implements CommerceCartService
{
    private AddToCartStrategy addToCartStrategy;

    public DefaultCommerceCartService(AddToCartStrategy addToCartStrategy)
    {
        this.addToCartStrategy = addToCartStrategy;
    }

    @Override
    public void addToCart(CommerceCartParameter parameter)
    {
        addToCartStrategy.addToCart(parameter);
    }
}
