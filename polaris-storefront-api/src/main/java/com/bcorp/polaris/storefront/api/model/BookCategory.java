package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BookCategory
{
    private Long id;
    private String name;
    private Long parentId;

    @JsonCreator
    public BookCategory(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("parent_id") Long parentId)
    {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
