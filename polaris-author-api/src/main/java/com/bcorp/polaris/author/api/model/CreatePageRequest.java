package com.bcorp.polaris.author.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePageRequest
{
    private Long chapterId;
    private String title;
    private Integer sortPosition;

    @JsonCreator
    public CreatePageRequest(
            @JsonProperty("chapter_id") Long chapterId,
            @JsonProperty("title") String title,
            @JsonProperty("sort_position") Integer sortPosition)
    {
        this.chapterId = chapterId;
        this.title = title;
        this.sortPosition = sortPosition;
    }
}
