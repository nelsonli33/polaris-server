package com.bcorp.polaris.author.facade.impl;

import com.bcorp.polaris.author.facade.AuthorPageFacade;
import com.bcorp.polaris.author.facade.mapper.AuthorPageMapper;
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

    private AuthorPageMapper authorPageMapper;

    @Autowired
    public DefaultAuthorPageFacade(AuthorPageService authorPageService,
                                   AuthorBookService authorBookService,
                                   AuthorChapterService authorChapterService,
                                   DSLContext dslContext,
                                   AuthorPageMapper authorPageMapper)
    {
        this.authorPageService = authorPageService;
        this.authorBookService = authorBookService;
        this.authorChapterService = authorChapterService;
        this.dslContext = dslContext;
        this.authorPageMapper = authorPageMapper;
    }

    public PageDto getPage(Long pageId)
    {
        validateParameterNotNullStandardMessage("pageId", pageId);
        final PageRecord pageRecord = authorPageService.getPageForId(pageId);
        return authorPageMapper.toDto(pageRecord);
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
        return authorPageMapper.toDto(createdPageRecord);
    }

    @Override
    public PageDto savePage(SavePageDto savePageDto)
    {
        validateParameterNotNullStandardMessage("savePageDto", savePageDto);
        final Long pageId = savePageDto.getPageId();
        final PageRecord pageRecord = authorPageService.getPageForId(pageId);
        authorPageMapper.update(savePageDto, pageRecord);
        pageRecord.update();
        pageRecord.refresh();
        return authorPageMapper.toDto(pageRecord);
    }


}
