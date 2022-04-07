package com.bcorp.polaris.storefront.service.strategy.impl;

import com.bcorp.polaris.storefront.service.CartService;
import com.bcorp.polaris.storefront.service.strategy.CartCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCartStrategy
{
    private CartService cartService;
    private CartCalculationStrategy cartCalculationStrategy;

    public CartService getCartService()
    {
        return cartService;
    }

    @Autowired
    public void setCartService(CartService cartService)
    {
        this.cartService = cartService;
    }

    public CartCalculationStrategy getCartCalculationStrategy()
    {
        return cartCalculationStrategy;
    }

    @Autowired
    public void setCartCalculationStrategy(CartCalculationStrategy cartCalculationStrategy)
    {
        this.cartCalculationStrategy = cartCalculationStrategy;
    }
}
