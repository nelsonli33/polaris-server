package com.bcorp.polaris.author.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBookDto
{
    private String title;
    private String subtitle;
    private List<Long> categoryIds;
    private BigDecimal price;
    private String synopsis;
    private List<String> acquisition;
    private String cover;
}
