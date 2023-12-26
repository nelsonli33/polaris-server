package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Book
{
    private Long id;
    private Long userId;
    private String title;
    private String subtitle;
    private Byte priceType;
    private BigDecimal price;
    private String synopsis;
    private List<String> acquisition;
    private String cover;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<BookCategory> categories;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TableOfContent tableOfContent;

    private LocalDateTime publishedAt;
    private Byte status;
    private Integer characterCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonCreator
    public Book(
            @JsonProperty("id") Long id,
            @JsonProperty("user_id") Long userId,
            @JsonProperty("title") String title,
            @JsonProperty("subtitle") String subtitle,
            @JsonProperty("price_type") Byte priceType,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("synopsis") String synopsis,
            @JsonProperty("acquisition") List<String> acquisition,
            @JsonProperty("cover") String cover,
            @JsonProperty("categories") List<BookCategory> categories,
            @JsonProperty("toc") TableOfContent tableOfContent,
            @JsonProperty("published_at") LocalDateTime publishedAt,
            @JsonProperty("status") Byte status,
            @JsonProperty("character_count") Integer characterCount,
            @JsonProperty("created_at") LocalDateTime createdAt,
            @JsonProperty("updated_at") LocalDateTime updatedAt)
    {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.subtitle = subtitle;
        this.priceType = priceType;
        this.price = price;
        this.synopsis = synopsis;
        this.acquisition = acquisition;
        this.cover = cover;
        this.categories = categories;
        this.tableOfContent = tableOfContent;
        this.publishedAt = publishedAt;
        this.status = status;
        this.characterCount = characterCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
