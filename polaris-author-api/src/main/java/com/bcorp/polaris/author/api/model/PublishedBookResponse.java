package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PublishedBookResponse
{
    private Long bookId;

    @JsonCreator
    public PublishedBookResponse(
            @JsonProperty("book_id") Long bookId
    )
    {
        this.bookId = bookId;
    }
}
