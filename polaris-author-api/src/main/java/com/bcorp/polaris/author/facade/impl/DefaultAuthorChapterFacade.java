package com.bcorp.polaris.author.facade.impl;

import com.bcorp.polaris.author.dto.CreateChapterRespDto;
import com.bcorp.polaris.author.facade.AuthorChapterFacade;
import com.bcorp.polaris.author.facade.mapper.AuthorChapterMapper;
import com.bcorp.polaris.author.facade.mapper.AuthorPageMapper;
import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.author.service.AuthorChapterService;
import com.bcorp.polaris.author.service.AuthorPageService;
import com.bcorp.polaris.core.dto.ChapterDto;
import com.bcorp.polaris.core.dto.CreateChapterDto;
import com.bcorp.polaris.core.dto.PageDto;
import com.bcorp.polaris.core.dto.UpdateChapterDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bcorp.polaris.core.model.tables.Page.PAGE;

@Component(value = "authorChapterFacade")
public class DefaultAuthorChapterFacade implements AuthorChapterFacade
{
    private AuthorChapterService authorChapterService;
    private AuthorBookService authorBookService;

    private AuthorPageService authorPageService;
    private AuthorChapterMapper authorChapterMapper;
    private AuthorPageMapper authorPageMapper;
    private DSLContext dslContext;

    @Autowired
    public DefaultAuthorChapterFacade(AuthorChapterService authorChapterService,
                                      AuthorBookService authorBookService,
                                      AuthorPageService authorPageService,
                                      AuthorChapterMapper authorChapterMapper,
                                      AuthorPageMapper authorPageMapper,
                                      DSLContext dslContext)
    {
        this.authorChapterService = authorChapterService;
        this.authorBookService = authorBookService;
        this.authorPageService = authorPageService;
        this.authorChapterMapper = authorChapterMapper;
        this.authorPageMapper = authorPageMapper;
        this.dslContext = dslContext;
    }

    @Override
    public CreateChapterRespDto createNewChapter(CreateChapterDto dto)
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

        final ChapterDto chapterDto = authorChapterMapper.toDto(newChapter);
        final PageDto pageDto = autoGenNewPageForChapter(bookRecord, newChapter);

        return CreateChapterRespDto.builder()
                .chapterDto(chapterDto)
                .pageDto(pageDto)
                .build();
    }

    @Override
    public ChapterDto updateChapter(UpdateChapterDto dto)
    {
        final BookRecord bookRecord = authorBookService.getBookForId(dto.getBookId());
        final ChapterRecord chapterRecord = authorChapterService.getChapterForId(bookRecord, dto.getChapterId());
        final ChapterRecord updatedChapter
                = authorChapterService.updateChapter(chapterRecord, dto.getTitle());

        return authorChapterMapper.toDto(updatedChapter);
    }


    protected PageDto autoGenNewPageForChapter(BookRecord bookRecord, ChapterRecord chapterRecord)
    {
        final PageRecord pageRecord = dslContext.newRecord(PAGE);
        pageRecord.setTitle("未命名頁面");
        pageRecord.setSortPosition(1);
        final PageRecord page = authorPageService.createPage(pageRecord, bookRecord, chapterRecord);
        return authorPageMapper.toDto(page);
    }
}
