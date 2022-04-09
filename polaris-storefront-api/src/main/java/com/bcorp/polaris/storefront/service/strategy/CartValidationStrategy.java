package com.bcorp.polaris.storefront.service.strategy;

import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;

public interface CartValidationStrategy
{
    void validateCart(final CommerceCartParameter parameter);
}
