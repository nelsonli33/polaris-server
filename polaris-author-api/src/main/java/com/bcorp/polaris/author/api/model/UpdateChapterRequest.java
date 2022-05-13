package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateChapterRequest
{
    private String title;

    @JsonCreator
    public UpdateChapterRequest(
            @JsonProperty("title") String title
    )
    {
        this.title = title;
    }
}
