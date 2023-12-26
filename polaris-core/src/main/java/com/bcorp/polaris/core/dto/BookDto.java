package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto
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
    private LocalDateTime publishedAt;
    private Byte status;
    private Integer characterCount;
    private TableOfContentDto tableOfContent;
    private List<BookCategoryDto> categories;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDto author;
}
