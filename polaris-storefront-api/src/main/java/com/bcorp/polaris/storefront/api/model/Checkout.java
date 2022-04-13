package com.bcorp.polaris.storefront.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Checkout
{
    List<PaymentMode> paymentMethods;
}
