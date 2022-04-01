package com.bcorp.polaris.storefront.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ServerErrorResponse
{
    private ServerResponse error;

    @JsonCreator
    public ServerErrorResponse(
            @JsonProperty("error") ServerResponse error)
    {
        this.error = error;
    }
}
