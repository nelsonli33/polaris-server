package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePageDto
{
    private Long bookId;
    private Long chapterId;
    private String title;
    private Long beforePageId;
    private Long afterPageId;
}
