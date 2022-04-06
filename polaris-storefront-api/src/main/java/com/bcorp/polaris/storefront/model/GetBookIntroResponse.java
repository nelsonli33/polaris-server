package com.bcorp.polaris.storefront.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetBookIntroResponse
{
    private Book book;

    @JsonCreator
    public GetBookIntroResponse(
            @JsonProperty("book") Book book
    )
    {
        this.book = book;
    }
}
