package com.bcorp.polaris.storefront.dao.service;

import com.bcorp.polaris.storefront.dto.CommerceCartParameter;

public interface CommerceCartService
{
    void addToCart(final CommerceCartParameter parameter);

    void removeCartLineItem(CommerceCartParameter parameter);

    void removeAllCartLineItems(CommerceCartParameter parameter);

    boolean validateCartIsValid(CommerceCartParameter parameter);
}
