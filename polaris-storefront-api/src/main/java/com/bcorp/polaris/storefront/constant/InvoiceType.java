package com.bcorp.polaris.storefront.constant;

import com.bcorp.polaris.core.constant.CodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InvoiceType implements CodeEnum<Integer>
{
    PERSON(1),

    COMPANY(2),

    DONATION(3);

    private Integer code;
}
