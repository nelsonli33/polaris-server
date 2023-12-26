package com.bcorp.polaris.storefront.dao.service;

import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.dto.PlaceOrderDto;

public interface CheckoutFactory
{
    CheckoutBo createCheckoutBo(PlaceOrderDto placeOrderDto);
}
