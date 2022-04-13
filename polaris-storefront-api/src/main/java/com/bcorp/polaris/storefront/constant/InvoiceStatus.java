package com.bcorp.polaris.storefront.constant;

import com.bcorp.polaris.core.constant.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvoiceStatus implements CodeEnum<Integer>
{
    SUCCESS(1),

    FAILURE(2),

    PENDING(3),

    VOIDED(4); // 已作廢

    private Integer code;
}
