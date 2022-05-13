package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetPageResponse
{
    private Page page;

    @JsonCreator
    public GetPageResponse(
            @JsonProperty("page") Page page
    )
    {
        this.page = page;
    }
}
