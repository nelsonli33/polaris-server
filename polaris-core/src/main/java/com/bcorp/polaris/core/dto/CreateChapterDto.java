package com.bcorp.polaris.core.dto;

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
    private String title;
    private Long bookId;
    private Long beforeChapterId;
    private Long afterChapterId;
}
