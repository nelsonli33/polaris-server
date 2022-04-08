package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveLineItemResponse
{
    private Cart cart;

    @JsonCreator
    public RemoveLineItemResponse(
            @JsonProperty("cart") Cart cart
    )
    {
        this.cart = cart;
    }
}
