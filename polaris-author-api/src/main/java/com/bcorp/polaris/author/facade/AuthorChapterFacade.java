package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.author.dto.ChapterDto;
import com.bcorp.polaris.author.dto.CreateChapterDto;
import com.bcorp.polaris.author.dto.UpdateChapterDto;

public interface AuthorChapterFacade
{
    ChapterDto createNewChapter(CreateChapterDto dto);

    ChapterDto updateChapter(UpdateChapterDto dto);

}
