package com.bcorp.polaris.storefront.api.model;

import com.bcorp.polaris.core.payload.ServerAPIResponse;
import com.bcorp.polaris.core.payload.ServerResponse;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCheckoutResponse implements ServerAPIResponse
{
    private ServerResponse error;
    private Checkout checkout;

    @JsonCreator
    public GetCheckoutResponse(
            @JsonProperty("error") ServerResponse error,
            @JsonProperty("checkout") Checkout checkout
    )
    {
        this.error = error;
        this.checkout = checkout;
    }
}
