package com.bcorp.polaris.storefront.service;

public interface EcpayPaymentService
{
    String genCreditOnceCheckoutForm(String orderCode,
                                     String totalPrice,
                                     String itemName,
                                     String tradeDesc,
                                     String returnUrl,
                                     String orderResultUrl,
                                     String clientBackUrl);
}
