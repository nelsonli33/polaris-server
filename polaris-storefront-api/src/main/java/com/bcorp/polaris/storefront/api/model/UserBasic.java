package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBasic
{
    private String name;
    private String uid;
    private String email;
    private String avatar;

    @JsonCreator
    public UserBasic(
            @JsonProperty("name") String name,
            @JsonProperty("uid") String uid,
            @JsonProperty("email") String email,
            @JsonProperty("avatar") String avatar
    )
    {
        this.name = name;
        this.uid = uid;
        this.email = email;
        this.avatar = avatar;
    }
}
