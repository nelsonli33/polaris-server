package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class PlaceOrderResponse
{
    @NotNull(message = "order_code cannot be null")
    private String orderCode;
    @NotNull(message = "checkout_form cannot be null")
    private String checkoutForm;

    public PlaceOrderResponse(
            @JsonProperty("order_code") String orderCode,
            @JsonProperty("checkout_form") String checkoutForm
    )
    {
        this.orderCode = orderCode;
        this.checkoutForm = checkoutForm;
    }
}
