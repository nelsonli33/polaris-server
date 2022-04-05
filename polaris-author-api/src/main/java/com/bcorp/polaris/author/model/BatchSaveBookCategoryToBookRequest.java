package com.bcorp.polaris.author.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BatchSaveBookCategoryToBookRequest
{
    private List<Long> bookCategoryIds;

    @JsonCreator
    public BatchSaveBookCategoryToBookRequest(
            @JsonProperty("book_category_ids") List<Long> bookCategoryIds
    )
    {
        this.bookCategoryIds = bookCategoryIds;
    }
}
