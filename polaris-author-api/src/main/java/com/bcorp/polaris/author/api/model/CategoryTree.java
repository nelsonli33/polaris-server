package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryTree
{
    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryTree> children;

    @JsonCreator
    public CategoryTree(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("parent_id") Long parentId,
            @JsonProperty("children") List<CategoryTree> children)
    {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.children = children;
    }
}
