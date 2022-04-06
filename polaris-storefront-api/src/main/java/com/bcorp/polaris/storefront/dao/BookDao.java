package com.bcorp.polaris.storefront.dao;

import org.jooq.Record;

public interface BookDao
{
    Record findBookWithAuthorById(Long bookId);
}
