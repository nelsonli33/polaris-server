package com.bcorp.polaris.author.dao.impl;

import com.bcorp.polaris.author.dao.AuthorChapterDao;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Repository
public class DefaultAuthorChapterDao implements AuthorChapterDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultAuthorChapterDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public List<ChapterRecord> findAllChaptersByBook(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "BookRecord must not be null");

        return dslContext.selectFrom(CHAPTER)
                .where(CHAPTER.BOOK_ID.eq(bookRecord.getId()))
                .and(CHAPTER.IS_DELETED.eq((byte) 0))
                .orderBy(CHAPTER.SORT_POSITION)
                .fetchInto(ChapterRecord.class);
    }

    @Override
    public int countChaptersByBook(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "BookRecord must not be null");

        return dslContext.fetchCount(DSL.selectFrom(CHAPTER)
                .where(CHAPTER.BOOK_ID.eq(bookRecord.getId()))
                .and(CHAPTER.IS_DELETED.eq((byte) 0)));

    }

    public ChapterRecord saveChapter(ChapterRecord chapter)
    {
        validateParameterNotNull(chapter, "ChapterRecord must not be null");
        chapter.store();
        return chapter;
    }

    public void moveBackwardAfterChapterSortPos(BookRecord bookRecord, int sortPosition)
    {
        validateParameterNotNull(bookRecord, "BookRecord must not be null");

        dslContext.update(CHAPTER)
                .set(CHAPTER.SORT_POSITION, CHAPTER.SORT_POSITION.plus(1))
                .where(CHAPTER.BOOK_ID.eq(bookRecord.getId()))
                .and(CHAPTER.SORT_POSITION.gt(sortPosition))
                .execute();
    }

}
