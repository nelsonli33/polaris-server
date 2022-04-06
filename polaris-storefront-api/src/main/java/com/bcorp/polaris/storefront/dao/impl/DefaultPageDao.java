package com.bcorp.polaris.storefront.dao.impl;

import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.storefront.dao.PageDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static com.bcorp.polaris.core.model.tables.Page.PAGE;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Repository
public class DefaultPageDao implements PageDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultPageDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public Map<ChapterRecord, List<PageRecord>> findAllPageRecordsGroupByChapterByBookId(Long bookId)
    {
        validateParameterNotNull(bookId, "bookId must not be null");
        return dslContext.select(PAGE.ID, PAGE.TITLE)
                .select(CHAPTER.fields())
                .from(PAGE)
                .join(CHAPTER).on(PAGE.CHAPTER_ID.eq(CHAPTER.ID))
                .where(PAGE.BOOK_ID.eq(bookId))
                .fetchGroups(r -> r.into(ChapterRecord.class), r -> r.into(PageRecord.class));
    }

}
