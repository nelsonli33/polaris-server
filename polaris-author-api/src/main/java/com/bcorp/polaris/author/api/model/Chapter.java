package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Chapter
{
    private Long id;
    private String title;
    private Long bookId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Page> pages;

    @JsonCreator
    public Chapter(
            @JsonProperty("id") Long id,
            @JsonProperty("title") String title,
            @JsonProperty("book_id") Long bookId,
            @JsonProperty("pages") List<Page> pages
    )
    {
        this.id = id;
        this.title = title;
        this.bookId = bookId;
        this.pages = pages;
    }
}
