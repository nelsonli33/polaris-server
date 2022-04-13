package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.core.dto.CartDto;

public interface CartFacade
{
    CartDto getCartForCurrentUser();

    CartDto addToCart(Long bookId);

    CartDto removeLineItem(Long bookId);

    CartDto clearCart();

    boolean validateCartIsValid();
}
