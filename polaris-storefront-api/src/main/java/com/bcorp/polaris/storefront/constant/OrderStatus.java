package com.bcorp.polaris.storefront.constant;

import com.bcorp.polaris.core.constant.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus implements CodeEnum<String>
{
    UNPAID("UNPAID"),

    READY_TO_SHIP("READY_TO_SHIP"),

    CANCELLED("CANCELLED"),

    TO_RETURN("TO_RETURN"),

    COMPLETED("COMPLETED"),

    CLOSE("CLOSE");

    private String code;
}
