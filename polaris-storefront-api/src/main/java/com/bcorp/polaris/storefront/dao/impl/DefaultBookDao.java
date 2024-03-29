package com.bcorp.polaris.storefront.dao.impl;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.storefront.dao.BookDao;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bcorp.polaris.core.model.tables.Book.BOOK;
import static com.bcorp.polaris.core.model.tables.User.USER;

@Repository
public class DefaultBookDao implements BookDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultBookDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public List<BookRecord> findAllBooks()
    {
        return dslContext.select().from(BOOK)
                .where(BOOK.STATUS.eq((byte) 1)).and(BOOK.IS_DELETED.eq((byte) 0))
                .fetchInto(BookRecord.class);
    }

    @Override
    public BookRecord findBookById(Long bookId)
    {
        return dslContext.fetchOne(BOOK, BOOK.ID.eq(bookId).and(BOOK.STATUS.eq((byte) 1)).and(BOOK.IS_DELETED.eq((byte) 0)));
    }

    public Record findBookWithAuthorById(Long bookId)
    {
        return dslContext.select()
                .from(BOOK)
                .join(USER).on(BOOK.USER_ID.eq(USER.ID))
                .where(BOOK.ID.eq(bookId)).and(BOOK.STATUS.eq((byte) 1)).and(BOOK.IS_DELETED.eq((byte) 0))
                .fetchOne();
    }
}
