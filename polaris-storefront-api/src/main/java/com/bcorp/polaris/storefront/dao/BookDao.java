package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import org.jooq.Record;

import java.util.List;

public interface BookDao
{
    List<BookRecord> findAllBooks();

    BookRecord findBookById(Long bookId);

    Record findBookWithAuthorById(Long bookId);
}
