package com.bcorp.polaris.storefront.constant;

public enum PaymentType
{
    CREDIT_CARD_ONCE("CreditCardOnce");

    private String paymentType;

    PaymentType(String paymentType)
    {
        this.paymentType = paymentType;
    }

    public String getPaymentType()
    {
        return paymentType;
    }

    public static String getPaymentTypeCode(final String paymentType)
    {
        return PaymentType.valueOf(paymentType).paymentType;
    }
}
