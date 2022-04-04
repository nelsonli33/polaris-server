package com.bcorp.polaris.author.dao.impl;

import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.model.tables.Page.PAGE;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Repository(value = "authorPageDao")
public class DefaultAuthorPageDao implements AuthorPageDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultAuthorPageDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    @Override
    public Map<Long, List<PageRecord>> findAllPageTitleWithChapterByBook(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "BookRecord must not be null");
        return dslContext
                .select(PAGE.ID, PAGE.CHAPTER_ID, PAGE.BOOK_ID, PAGE.TITLE)
                .from(PAGE)
                .where(PAGE.BOOK_ID.eq(bookRecord.getId()))
                .fetchGroups(PAGE.CHAPTER_ID, r -> r.into(PageRecord.class));
    }

    @Override
    public PageRecord save(PageRecord pageRecord)
    {
        pageRecord.store();
        return pageRecord;
    }
}
