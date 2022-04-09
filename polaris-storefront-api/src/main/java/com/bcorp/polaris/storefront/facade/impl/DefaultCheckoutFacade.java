package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.facade.CheckoutFacade;
import com.bcorp.polaris.storefront.service.CartService;
import org.springframework.stereotype.Component;

@Component(value = "checkoutFacade")
public class DefaultCheckoutFacade implements CheckoutFacade
{
    private CartService cartService;

    public DefaultCheckoutFacade(CartService cartService)
    {
        this.cartService = cartService;
    }

    @Override
    public boolean hasValidCart()
    {
        CartBo cartBo = getCart();
        return cartBo.getCart() != null && cartBo.getLineItems() != null && !cartBo.getLineItems().isEmpty();
    }

    protected CartBo getCart()
    {
        return cartService.getCartDetailForCurrentUser();
    }

}
