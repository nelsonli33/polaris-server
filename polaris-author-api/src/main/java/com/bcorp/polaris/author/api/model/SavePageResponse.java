package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SavePageResponse
{
    private Page page;

    public SavePageResponse(
            @JsonProperty("page") Page page
    )
    {
        this.page = page;
    }
}
