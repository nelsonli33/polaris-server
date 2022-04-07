package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.core.dto.CartDto;

public interface CartFacade
{
    CartDto addToCart(Long bookId);
}
