package com.bcorp.polaris.author.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Book
{
    private Long id;
    private Long userId;
    private Long bookCategoryId;
    private String title;
    private Byte priceType;
    private BigDecimal price;
    private String synopsis;
    private String acquisition;
    private String cover;
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
            @JsonProperty("book_category_id") Long bookCategoryId,
            @JsonProperty("title") String title,
            @JsonProperty("price_type") Byte priceType,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("synopsis") String synopsis,
            @JsonProperty("acquisition") String acquisition,
            @JsonProperty("cover") String cover,
            @JsonProperty("toc") TableOfContent tableOfContent,
            @JsonProperty("published_at") LocalDateTime publishedAt,
            @JsonProperty("status") Byte status,
            @JsonProperty("character_count") Integer characterCount,
            @JsonProperty("created_at") LocalDateTime createdAt,
            @JsonProperty("updated_at") LocalDateTime updatedAt)
    {
        this.id = id;
        this.userId = userId;
        this.bookCategoryId = bookCategoryId;
        this.title = title;
        this.priceType = priceType;
        this.price = price;
        this.synopsis = synopsis;
        this.acquisition = acquisition;
        this.cover = cover;
        this.tableOfContent = tableOfContent;
        this.publishedAt = publishedAt;
        this.status = status;
        this.characterCount = characterCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
