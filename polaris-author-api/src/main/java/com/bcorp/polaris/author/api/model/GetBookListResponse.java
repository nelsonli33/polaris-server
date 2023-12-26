package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetBookListResponse
{
    private List<Book> books;

    @JsonCreator
    public GetBookListResponse(
            @JsonProperty("books") List<Book> books
    )
    {
        this.books = books;
    }
}
