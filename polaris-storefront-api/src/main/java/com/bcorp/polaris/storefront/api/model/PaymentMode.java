package com.bcorp.polaris.storefront.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentMode
{
    private String code;
    private String name;
}
