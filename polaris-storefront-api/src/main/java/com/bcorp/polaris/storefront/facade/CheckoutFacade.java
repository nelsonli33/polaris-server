package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.core.dto.OrderDto;
import com.bcorp.polaris.storefront.dto.CheckoutDto;
import com.bcorp.polaris.storefront.dto.PaymentModeDto;
import com.bcorp.polaris.storefront.dto.PlaceOrderDto;

import java.util.List;

public interface CheckoutFacade
{
    boolean hasValidCart();

    CheckoutDto getCheckout();

    List<PaymentModeDto> getSupportedPaymentMethods();

    OrderDto placeOrder(PlaceOrderDto placeOrderDto);
}
