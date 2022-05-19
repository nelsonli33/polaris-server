package com.bcorp.polaris.author.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreatePageRequest
{
    @NotNull(message = "Book Id must not be empty")
    private Long bookId;
    @NotNull(message = "Chapter Id must not be empty")
    private Long chapterId;
    private String title;

    private Long beforePageId;
    private Long afterPageId;

    @JsonCreator
    public CreatePageRequest(
            @JsonProperty("book_id") Long bookId,
            @JsonProperty("chapter_id") Long chapterId,
            @JsonProperty("title") String title,
            @JsonProperty("before_page_id") Long beforePageId,
            @JsonProperty("after_page_id") Long afterPageId
    )
    {
        this.bookId = bookId;
        this.chapterId = chapterId;
        this.title = title;
        this.beforePageId = beforePageId;
        this.afterPageId = afterPageId;
    }
}
