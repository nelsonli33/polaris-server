package com.bcorp.polaris.storefront.dao.service.strategy;

import com.bcorp.polaris.storefront.dto.CommerceCartParameter;

public interface AddToCartStrategy
{
    void addToCart(CommerceCartParameter parameter);
}
