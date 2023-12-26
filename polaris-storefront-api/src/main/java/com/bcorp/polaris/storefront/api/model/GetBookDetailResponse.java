package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetBookDetailResponse
{
    private Book book;

    @JsonCreator
    public GetBookDetailResponse(
            @JsonProperty("book") Book book
    )
    {
        this.book = book;
    }
}
