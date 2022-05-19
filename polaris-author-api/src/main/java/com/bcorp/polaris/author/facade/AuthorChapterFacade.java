package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.author.dto.CreateChapterRespDto;
import com.bcorp.polaris.core.dto.ChapterDto;
import com.bcorp.polaris.core.dto.CreateChapterDto;
import com.bcorp.polaris.core.dto.UpdateChapterDto;

public interface AuthorChapterFacade
{
    CreateChapterRespDto createNewChapter(CreateChapterDto dto);

    ChapterDto updateChapter(UpdateChapterDto dto);

    void deleteChapter(Long bookId, Long chapterId);

}
