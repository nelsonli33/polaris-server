package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateChapterResponse
{
    private Chapter chapter;
    private Page page;

    @JsonCreator
    public CreateChapterResponse(
            @JsonProperty("chapter") Chapter chapter,
            @JsonProperty("page") Page page
    )
    {
        this.chapter = chapter;
        this.page = page;
    }
}
