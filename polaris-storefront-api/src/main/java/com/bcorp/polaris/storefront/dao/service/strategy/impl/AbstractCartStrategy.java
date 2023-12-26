package com.bcorp.polaris.storefront.dao.service.strategy.impl;

import com.bcorp.polaris.storefront.dao.service.CartService;
import com.bcorp.polaris.storefront.dao.service.strategy.CartCalculationStrategy;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCartStrategy
{
    private CartService cartService;
    private CartCalculationStrategy cartCalculationStrategy;
    private DSLContext dslContext;

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

    public DSLContext getDslContext()
    {
        return dslContext;
    }

    @Autowired
    public void setDslContext(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }
}
