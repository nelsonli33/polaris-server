package com.bcorp.polaris.storefront.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ServerResponse
{
    private int code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Error> errors;

    @JsonCreator
    public ServerResponse(
            @JsonProperty("code") int code,
            @JsonProperty("message") String message,
            @JsonProperty("errors") List<Error> errors)
    {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }
}
