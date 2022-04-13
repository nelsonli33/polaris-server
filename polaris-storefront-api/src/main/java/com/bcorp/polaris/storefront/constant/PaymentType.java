package com.bcorp.polaris.storefront.constant;

import com.bcorp.polaris.core.constant.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType implements CodeEnum<String>
{
    CREDIT_CARD_ONCE("CreditCardOnce", "信用卡結帳"),

    WEB_ATM("WebATM", "網路 ATM"),

    CVS("CVS", "超商條碼");

    private String code;
    private String name;
}
