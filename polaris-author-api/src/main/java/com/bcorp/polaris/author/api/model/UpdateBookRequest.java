package com.bcorp.polaris.author.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class UpdateBookRequest
{
    @NotBlank(message = "內容標題 必填")
    private String title;
    private List<Long> categoryIds;
    private BigDecimal price;
    private String synopsis;
    private String acquisition;
    private String cover;

    @JsonCreator
    public UpdateBookRequest(
            @JsonProperty("title") String title,
            @JsonProperty("category_ids") List<Long> categoryIds,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("synopsis") String synopsis,
            @JsonProperty("acquisition") String acquisition,
            @JsonProperty("cover") String cover
    )
    {
        this.title = title;
        this.categoryIds = categoryIds;
        this.price = price;
        this.synopsis = synopsis;
        this.acquisition = acquisition;
        this.cover = cover;
    }
}
