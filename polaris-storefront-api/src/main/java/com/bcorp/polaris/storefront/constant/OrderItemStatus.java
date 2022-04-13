package com.bcorp.polaris.storefront.constant;

import com.bcorp.polaris.core.constant.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderItemStatus implements CodeEnum<String>
{
    PENDING("PENDING"),

    COMPLETED("COMPLETED"); // book add to user book shelf

    private String code;
}
