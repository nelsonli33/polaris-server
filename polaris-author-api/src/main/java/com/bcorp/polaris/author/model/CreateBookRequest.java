package com.bcorp.polaris.author.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CreateBookRequest
{
    @NotBlank(message = "書名 必填")
    private String title;

    @JsonCreator
    public CreateBookRequest(
            @JsonProperty("title") String title
    )
    {
        this.title = title;
    }
}
