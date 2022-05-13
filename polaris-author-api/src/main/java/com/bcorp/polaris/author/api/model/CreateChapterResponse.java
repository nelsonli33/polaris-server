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

    @JsonCreator
    public CreateChapterResponse(
            @JsonProperty("chapter") Chapter chapter
    )
    {
        this.chapter = chapter;
    }
}
