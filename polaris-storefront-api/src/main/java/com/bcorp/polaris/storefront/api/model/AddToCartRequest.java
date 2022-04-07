package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AddToCartRequest
{
    @NotNull(message = "book_id cannot be null")
    private Long bookId;

    @JsonCreator
    public AddToCartRequest(
            @JsonProperty("book_id") Long bookId
    )
    {
        this.bookId = bookId;
    }
}
