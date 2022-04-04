package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.author.service.AuthorPageService;
import com.bcorp.polaris.author.service.AuthorUserService;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bcorp.polaris.core.model.tables.Page.PAGE;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Service(value = "authorPageService")
public class DefaultAuthorPageService implements AuthorPageService
{
    private DSLContext dslContext;
    private AuthorUserService authorUserService;
    private AuthorPageDao authorPageDao;

    @Autowired
    public DefaultAuthorPageService(DSLContext dslContext, AuthorUserService authorUserService, AuthorPageDao authorPageDao)
    {
        this.dslContext = dslContext;
        this.authorUserService = authorUserService;
        this.authorPageDao = authorPageDao;
    }

    @Override
    public PageRecord getPageForId(Long pageId)
    {
        validateParameterNotNull(pageId, "PageId must not be null");
        final UserRecord currentAuthorUser = authorUserService.getCurrentAuthorUser();

        final PageRecord pageRecord = dslContext.fetchOne(PAGE, PAGE.ID.eq(pageId).and(PAGE.USER_ID.eq(currentAuthorUser.getId())));
        if (pageRecord == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.RECORD_NOT_FOUND, "Page: " + pageId + "not found.");
        }
        return pageRecord;
    }


    @Override
    public PageRecord createPage(PageRecord pageRecord, BookRecord bookRecord, ChapterRecord chapterRecord)
    {
        validateParameterNotNull(bookRecord, "BookRecord cannot be null");
        validateParameterNotNull(chapterRecord, "ChapterRecord cannot be null");

        final UserRecord currentAuthorUser = authorUserService.getCurrentAuthorUser();
        pageRecord.setBookId(bookRecord.getId());
        pageRecord.setChapterId(chapterRecord.getId());
        pageRecord.setUserId(currentAuthorUser.getId());
        return authorPageDao.save(pageRecord);
    }
}
