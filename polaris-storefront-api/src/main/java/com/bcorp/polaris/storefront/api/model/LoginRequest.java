package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class LoginRequest
{
    @NotBlank(message = "E-mail 必填")
    private String uid;
    @NotBlank(message = "密碼 必填")
    private String password;

    @JsonCreator
    public LoginRequest(
            @JsonProperty("uid") String uid,
            @JsonProperty("password") String password)
    {
        this.uid = uid;
        this.password = password;
    }
}
