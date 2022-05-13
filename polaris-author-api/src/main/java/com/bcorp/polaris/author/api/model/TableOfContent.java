package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TableOfContent
{
    private List<Chapter> chapters;

    @JsonCreator
    public TableOfContent(
            @JsonProperty("chapters") List<Chapter> chapters
    )
    {
        this.chapters = chapters;
    }
}
