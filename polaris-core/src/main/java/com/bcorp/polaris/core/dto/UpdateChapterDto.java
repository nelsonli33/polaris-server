package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateChapterDto
{
    private String title;
    private Long bookId;
    private Long chapterId;
}
