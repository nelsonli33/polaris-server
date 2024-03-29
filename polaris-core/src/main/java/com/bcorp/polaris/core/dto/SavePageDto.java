package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavePageDto
{
    private Long pageId;
    private String title;
    private String description;
    private String body;
    private Integer characterCount;
}
