package com.bcorp.polaris.author.dao.impl;

import com.bcorp.polaris.author.dao.AuthorBookCategoryDao;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bcorp.polaris.core.model.tables.BookCategory.BOOK_CATEGORY;
import static com.bcorp.polaris.core.model.tables.BookCategoryRel.BOOK_CATEGORY_REL;

@Repository
public class DefaultAuthorBookCategoryDao implements AuthorBookCategoryDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultAuthorBookCategoryDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }


    public List<BookCategoryRecord> findAllBookCategories()
    {
        return dslContext.select().from(BOOK_CATEGORY)
                .where(BOOK_CATEGORY.IS_VISIBLE.eq((byte) 1))
                .and(BOOK_CATEGORY.IS_DELETED.eq((byte) 0))
                .orderBy(BOOK_CATEGORY.SORT_POSITION.asc())
                .fetchInto(BookCategoryRecord.class);
    }

    public List<BookCategoryRecord> findAllBookCategoriesByIds(List<Long> bookCategoryIds)
    {
        return dslContext.select().from(BOOK_CATEGORY)
                .where(BOOK_CATEGORY.ID.in(bookCategoryIds))
                .and(BOOK_CATEGORY.IS_DELETED.eq((byte) 0))
                .fetchInto(BookCategoryRecord.class);
    }

    public List<BookCategoryRecord> findBookCategoriesByBook(BookRecord bookRecord)
    {
        return dslContext.select().from(BOOK_CATEGORY)
                .join(BOOK_CATEGORY_REL).on(BOOK_CATEGORY_REL.BOOK_CATEGORY_ID.eq(BOOK_CATEGORY.ID))
                .where(BOOK_CATEGORY_REL.BOOK_ID.eq(bookRecord.getId()))
                .fetchInto(BookCategoryRecord.class);
    }
}
