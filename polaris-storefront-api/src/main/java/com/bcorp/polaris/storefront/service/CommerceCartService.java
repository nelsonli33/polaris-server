package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;

public interface CommerceCartService
{
    void addToCart(final CommerceCartParameter parameter);
}