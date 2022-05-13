package com.bcorp.polaris.author.facade.impl;

import com.bcorp.polaris.author.facade.AuthorChapterFacade;
import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.author.service.AuthorChapterService;
import com.bcorp.polaris.core.dto.ChapterDto;
import com.bcorp.polaris.core.dto.CreateChapterDto;
import com.bcorp.polaris.core.dto.UpdateChapterDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "authorChapterFacade")
public class DefaultAuthorChapterFacade implements AuthorChapterFacade
{
    private AuthorChapterService authorChapterService;
    private AuthorBookService authorBookService;

    @Autowired
    public DefaultAuthorChapterFacade(AuthorChapterService authorChapterService, AuthorBookService authorBookService)
    {
        this.authorChapterService = authorChapterService;
        this.authorBookService = authorBookService;
    }

    @Override
    public ChapterDto createNewChapter(CreateChapterDto dto)
    {
        final BookRecord bookRecord = authorBookService.getBookForId(dto.getBookId());

        authorChapterService.validateAddChapterIsValid(bookRecord);


        ChapterRecord belowChapterRecord = null;
        if (dto.getBelowChapterId() != null)
        {
            belowChapterRecord = authorChapterService.getChapterForId(bookRecord, dto.getBelowChapterId());
        }

        
        final ChapterRecord newChapter
                = authorChapterService.createChapter(bookRecord, dto.getTitle(), belowChapterRecord);
        return newChapter.into(ChapterDto.class);
    }

    @Override
    public ChapterDto updateChapter(UpdateChapterDto dto)
    {
        final BookRecord bookRecord = authorBookService.getBookForId(dto.getBookId());
        final ChapterRecord chapterRecord = authorChapterService.getChapterForId(bookRecord, dto.getChapterId());
        final ChapterRecord updatedChapter
                = authorChapterService.updateChapter(chapterRecord, dto.getTitle());
        return updatedChapter.into(ChapterDto.class);
    }


}
