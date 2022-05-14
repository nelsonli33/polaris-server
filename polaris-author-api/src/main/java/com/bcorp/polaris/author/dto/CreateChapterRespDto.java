package com.bcorp.polaris.author.dto;

import com.bcorp.polaris.core.dto.ChapterDto;
import com.bcorp.polaris.core.dto.PageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateChapterRespDto
{
    private ChapterDto chapterDto;
    private PageDto pageDto;
}
