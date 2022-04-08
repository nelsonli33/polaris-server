package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClearCartResponse
{
    private Cart cart;

    @JsonCreator
    public ClearCartResponse(
            @JsonProperty("cart") Cart cart
    )
    {
        this.cart = cart;
    }
}
