package com.bcorp.polaris.author.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto
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
    private LocalDateTime publishedAt;
    private Byte status;
    private Integer characterCount;
    private TableOfContentDto tableOfContent;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
