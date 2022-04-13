package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class PlaceOrderRequest
{
    @NotNull(message = "payment_method_code cannot be null")
    private String paymentMethodCode;

    private CheckoutInvoice checkoutInvoice;

    @JsonCreator
    public PlaceOrderRequest(
            @JsonProperty("payment_method_code") String paymentMethodCode,
            @JsonProperty("checkout_invoice") CheckoutInvoice checkoutInvoice
    )
    {
        this.paymentMethodCode = paymentMethodCode;
        this.checkoutInvoice = checkoutInvoice;
    }
}
