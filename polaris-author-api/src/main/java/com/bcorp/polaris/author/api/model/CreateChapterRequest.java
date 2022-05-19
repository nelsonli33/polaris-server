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
    private Long beforeChapterId;
    private Long afterChapterId;

    @JsonCreator
    public CreateChapterRequest(
            @JsonProperty("title") String title,
            @JsonProperty("before_chapter_id") Long beforeChapterId,
            @JsonProperty("after_chapter_id") Long afterChapterId
    )
    {
        this.title = title;
        this.beforeChapterId = beforeChapterId;
        this.afterChapterId = afterChapterId;
    }
}
