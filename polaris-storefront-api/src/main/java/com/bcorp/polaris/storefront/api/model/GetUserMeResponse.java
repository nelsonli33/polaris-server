package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetUserMeResponse
{
    private UserBasic user;

    @JsonCreator
    public GetUserMeResponse(
            @JsonProperty("user") UserBasic user
    )
    {
        this.user = user;
    }
}
