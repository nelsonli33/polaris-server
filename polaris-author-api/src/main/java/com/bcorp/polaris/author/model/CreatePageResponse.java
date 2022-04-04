package com.bcorp.polaris.author.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePageResponse
{
    private Page page;

    @JsonCreator
    public CreatePageResponse(
            @JsonProperty("page") Page page
    )
    {
        this.page = page;
    }
}
