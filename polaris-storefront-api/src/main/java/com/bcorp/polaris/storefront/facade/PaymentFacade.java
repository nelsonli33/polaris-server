package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.storefront.dto.PaymentDto;

public interface PaymentFacade
{
    PaymentDto startEcpayPayment(String orderCode);
}
