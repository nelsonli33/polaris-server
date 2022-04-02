package com.bcorp.polaris.author.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookResponse
{
    private Book book;

    @JsonCreator
    public CreateBookResponse(
            @JsonProperty("book") Book book
    )
    {
        this.book = book;
    }
}
