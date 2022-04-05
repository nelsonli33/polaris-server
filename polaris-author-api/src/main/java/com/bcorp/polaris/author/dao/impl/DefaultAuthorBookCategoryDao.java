package com.bcorp.polaris.author.dao.impl;

import com.bcorp.polaris.author.dao.AuthorBookCategoryDao;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bcorp.polaris.core.model.tables.BookCategory.BOOK_CATEGORY;

@Repository
public class DefaultAuthorBookCategoryDao implements AuthorBookCategoryDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultAuthorBookCategoryDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public List<BookCategoryRecord> findAllBookCategoriesByIds(List<Long> bookCategoryIds)
    {
        return dslContext.select().from(BOOK_CATEGORY)
                .where(BOOK_CATEGORY.ID.in(bookCategoryIds))
                .and(BOOK_CATEGORY.IS_DELETED.eq((byte) 0))
                .fetchInto(BookCategoryRecord.class);
    }
}
