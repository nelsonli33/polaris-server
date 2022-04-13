package com.bcorp.polaris.storefront.service.strategy;

import com.bcorp.polaris.storefront.dto.CommerceCartParameter;

public interface CartCalculationStrategy
{
    void calculateCart(CommerceCartParameter parameter);
}
