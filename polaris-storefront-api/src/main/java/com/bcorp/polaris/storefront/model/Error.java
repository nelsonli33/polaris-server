package com.bcorp.polaris.storefront.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error
{
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String field;
    private String message;

    @JsonCreator
    public Error(
            @JsonProperty("field") String field,
            @JsonProperty("message") String message)
    {
        this.message = message;
        this.field = field;
    }
}
