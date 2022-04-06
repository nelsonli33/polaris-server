package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse
{
    private String accessToken;

    @JsonCreator
    public LoginResponse(
            @JsonProperty("access_token") String accessToken
    )
    {
        this.accessToken = accessToken;
    }
}
