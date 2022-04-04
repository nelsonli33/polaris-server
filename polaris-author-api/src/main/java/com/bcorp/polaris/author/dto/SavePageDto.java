package com.bcorp.polaris.author.dto;

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
    private Long bookId;
    private Long pageId;
    private String title;
    private String body;
    private Integer characterCount;
}
