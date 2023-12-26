package com.bcorp.polaris.storefront.dao.impl;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.storefront.dao.BookCategoryDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bcorp.polaris.core.model.tables.BookCategory.BOOK_CATEGORY;
import static com.bcorp.polaris.core.model.tables.BookCategoryRel.BOOK_CATEGORY_REL;

@Repository(value = "bookCategoryDao")
public class DefaultBookCategoryDao implements BookCategoryDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultBookCategoryDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public List<BookCategoryRecord> findBookCategoriesByBook(BookRecord bookRecord)
    {
        return dslContext.select().from(BOOK_CATEGORY)
                .join(BOOK_CATEGORY_REL).on(BOOK_CATEGORY_REL.BOOK_CATEGORY_ID.eq(BOOK_CATEGORY.ID))
                .where(BOOK_CATEGORY_REL.BOOK_ID.eq(bookRecord.getId()))
                .fetchInto(BookCategoryRecord.class);
    }
}
