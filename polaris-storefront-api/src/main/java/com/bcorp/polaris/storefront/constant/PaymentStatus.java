package com.bcorp.polaris.storefront.constant;

import com.bcorp.polaris.core.constant.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus implements CodeEnum<String>
{
    UNPAID("UNPAID"),

    PAID_OVER_TIME("PAID_OVER_TIME"), // 超過付款時間

    PAID("PAID"),

    REFUNDED("REFUNDED"),

    VOIDED("VOIDED"); // 已作廢

    private String code;

}
