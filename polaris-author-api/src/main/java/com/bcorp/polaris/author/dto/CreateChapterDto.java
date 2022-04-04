package com.bcorp.polaris.author.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateChapterDto
{
    private Long bookId;
    private String title;
    private Long previousChapterId;
}
