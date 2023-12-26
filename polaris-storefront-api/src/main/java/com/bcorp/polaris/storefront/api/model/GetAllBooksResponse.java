package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllBooksResponse
{
    private List<Book> books;

    @JsonCreator
    public GetAllBooksResponse(
            @JsonProperty("books") List<Book> books
    )
    {
        this.books = books;
    }
}
