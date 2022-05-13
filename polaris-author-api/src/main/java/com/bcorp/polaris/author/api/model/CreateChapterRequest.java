package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateChapterRequest
{
    private String title;
    private Long previousChapterId;

    @JsonCreator
    public CreateChapterRequest(
            @JsonProperty("title") String title,
            @JsonProperty("previous_chapter_id") Long previousChapterId
    )
    {
        this.title = title;
        this.previousChapterId = previousChapterId;
    }
}
