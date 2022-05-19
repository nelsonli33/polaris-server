package com.bcorp.polaris.author.dao.impl;

import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<PageRecord> findAllPagesByBookAndChapter(BookRecord bookRecord, ChapterRecord chapterRecord)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");
        validateParameterNotNull(chapterRecord, "chapterRecord must not be null");

        return dslContext.selectFrom(PAGE)
                .where(PAGE.BOOK_ID.eq(bookRecord.getId()))
                .and(PAGE.CHAPTER_ID.eq(chapterRecord.getId()))
                .fetch();
    }

    @Override
    public Map<Long, List<PageRecord>> findAllPageTitleWithChapterByBook(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "BookRecord must not be null");
        return dslContext
                .select(PAGE.ID, PAGE.CHAPTER_ID, PAGE.BOOK_ID, PAGE.TITLE)
                .from(PAGE)
                .where(PAGE.BOOK_ID.eq(bookRecord.getId()))
                .orderBy(PAGE.RANK.asc())
                .fetchGroups(PAGE.CHAPTER_ID, r -> r.into(PageRecord.class));
    }


    @Override
    public void softDelete(PageRecord pageRecord)
    {
        validateParameterNotNull(pageRecord, "pageRecord must not be null");

        dslContext.update(PAGE)
                .set(PAGE.IS_DELETED, (byte) 1)
                .where(PAGE.ID.eq(pageRecord.getId()))
                .execute();
    }
    

    public void softDeletePagesByBookAndChapter(BookRecord bookRecord, ChapterRecord chapterRecord)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");
        validateParameterNotNull(chapterRecord, "chapterRecord must not be null");

        final List<PageRecord> pages = findAllPagesByBookAndChapter(bookRecord, chapterRecord);
        dslContext.batchUpdate(
                pages.stream().map(p -> {
                    p.setIsDeleted((byte) 0);
                    return p;
                }).collect(Collectors.toList())
        ).execute();
    }

    @Override
    public PageRecord save(PageRecord pageRecord)
    {
        pageRecord.store();
        return pageRecord;
    }
}
