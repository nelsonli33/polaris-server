package com.bcorp.polaris.author.facade.impl;

import com.bcorp.polaris.author.facade.AuthorPageFacade;
import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.author.service.AuthorChapterService;
import com.bcorp.polaris.author.service.AuthorPageService;
import com.bcorp.polaris.core.dto.CreatePageDto;
import com.bcorp.polaris.core.dto.PageDto;
import com.bcorp.polaris.core.dto.SavePageDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bcorp.polaris.core.model.tables.Page.PAGE;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Component(value = "authorPageFacade")
public class DefaultAuthorPageFacade implements AuthorPageFacade
{

    private AuthorPageService authorPageService;
    private AuthorBookService authorBookService;
    private AuthorChapterService authorChapterService;
    private DSLContext dslContext;

    @Autowired
    public DefaultAuthorPageFacade(AuthorPageService authorPageService,
                                   AuthorBookService authorBookService,
                                   AuthorChapterService authorChapterService,
                                   DSLContext dslContext)
    {
        this.authorPageService = authorPageService;
        this.authorBookService = authorBookService;
        this.authorChapterService = authorChapterService;
        this.dslContext = dslContext;
    }

    @Override
    public PageDto createPage(CreatePageDto createPageDto)
    {
        validateParameterNotNullStandardMessage("bookId", createPageDto.getBookId());
        validateParameterNotNullStandardMessage("chapterId", createPageDto.getChapterId());

        final Long bookId = createPageDto.getBookId();
        final BookRecord bookRecord = authorBookService.getBookForId(bookId);
        final ChapterRecord chapterRecord
                = authorChapterService.getChapterForId(bookRecord, createPageDto.getChapterId());

        final PageRecord pageRecord = dslContext.newRecord(PAGE);
        pageRecord.setTitle(createPageDto.getTitle());
        pageRecord.setSortPosition(createPageDto.getSortPosition());

        final PageRecord createdPageRecord
                = authorPageService.createPage(pageRecord, bookRecord, chapterRecord);
        return convert(createdPageRecord);
    }

    @Override
    public void savePage(SavePageDto savePageDto)
    {
        validateParameterNotNullStandardMessage("savePageDto", savePageDto);
        final Long pageId = savePageDto.getPageId();

        final PageRecord pageRecord = authorPageService.getPageForId(pageId);
        pageRecord.setTitle(savePageDto.getTitle());
        pageRecord.setBody(savePageDto.getBody());
        pageRecord.setCharacterCount(savePageDto.getCharacterCount());
        pageRecord.update();
    }


    private PageDto convert(PageRecord pageRecord)
    {
        return PageDto.builder()
                .id(pageRecord.getId())
                .bookId(pageRecord.getBookId())
                .chapterId(pageRecord.getChapterId())
                .authorId(pageRecord.getUserId())
                .title(pageRecord.getTitle())
                .body(pageRecord.getBody())
                .sortPosition(pageRecord.getSortPosition())
                .build();
    }
}
