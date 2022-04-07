package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import org.jooq.Record;

public interface BookDao
{
    BookRecord findBookById(Long bookId);

    Record findBookWithAuthorById(Long bookId);
}
