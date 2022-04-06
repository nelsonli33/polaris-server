package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Page
{
    private Long id;
    private Long bookId;
    private Long chapterId;
    private Long authorId;
    private String title;
    private String body;
    private Integer characterCount;
    private Integer sortPosition;

    @JsonCreator
    public Page(
            @JsonProperty("id") Long id,
            @JsonProperty("book_id") Long bookId,
            @JsonProperty("chapter_id") Long chapterId,
            @JsonProperty("author_id") Long authorId,
            @JsonProperty("title") String title,
            @JsonProperty("body") String body,
            @JsonProperty("character_count") Integer characterCount,
            @JsonProperty("sort_position") Integer sortPosition)
    {
        this.id = id;
        this.bookId = bookId;
        this.chapterId = chapterId;
        this.authorId = authorId;
        this.title = title;
        this.body = body;
        this.characterCount = characterCount;
        this.sortPosition = sortPosition;
    }
}
