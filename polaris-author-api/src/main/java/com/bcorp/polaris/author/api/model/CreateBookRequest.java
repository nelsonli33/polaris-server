package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class CreateBookRequest
{
    @NotBlank(message = "內容標題 必填")
    private String title;

    private List<Long> categoryIds;

    @JsonCreator
    public CreateBookRequest(
            @JsonProperty("title") String title,
            @JsonProperty("category_ids") List<Long> categoryIds
    )
    {
        this.title = title;
        this.categoryIds = categoryIds;
    }
}
