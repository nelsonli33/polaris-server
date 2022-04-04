package com.bcorp.polaris.author.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SavePageRequest
{
    private String title;
    private String body;
    private Integer characterCount;

    @JsonCreator
    public SavePageRequest(
            @JsonProperty("title") String title,
            @JsonProperty("body") String body,
            @JsonProperty("character_count") Integer characterCount
    )
    {
        this.title = title;
        this.body = body;
        this.characterCount = characterCount;
    }
}
