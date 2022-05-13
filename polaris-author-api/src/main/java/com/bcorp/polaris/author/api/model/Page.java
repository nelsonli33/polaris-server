package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Page
{
    private Long id;
    private String title;
    private String description;
    @JsonRawValue
    private Object body;
    private Integer characterCount;
    private Integer sortPosition;
    private Long bookId;
    private Long chapterId;
    private Long authorId;

    @JsonCreator
    public Page(
            @JsonProperty("id") Long id,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("body") Object body,
            @JsonProperty("character_count") Integer characterCount,
            @JsonProperty("sort_position") Integer sortPosition,
            @JsonProperty("book_id") Long bookId,
            @JsonProperty("chapter_id") Long chapterId,
            @JsonProperty("author_id") Long authorId
    )
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
        this.characterCount = characterCount;
        this.sortPosition = sortPosition;
        this.bookId = bookId;
        this.chapterId = chapterId;
        this.authorId = authorId;
    }
}
