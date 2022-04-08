package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCartResponse
{
    private Cart cart;

    @JsonCreator
    public GetCartResponse(
            @JsonProperty("cart") Cart cart
    )
    {
        this.cart = cart;
    }
}
