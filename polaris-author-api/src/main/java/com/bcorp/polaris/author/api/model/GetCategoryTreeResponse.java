package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetCategoryTreeResponse
{
    private List<CategoryTree> categories;

    @JsonCreator
    public GetCategoryTreeResponse(
            @JsonProperty("categories") List<CategoryTree> categories)
    {
        this.categories = categories;
    }
}
