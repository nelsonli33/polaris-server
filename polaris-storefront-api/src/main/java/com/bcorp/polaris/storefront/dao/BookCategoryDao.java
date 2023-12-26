package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;

import java.util.List;

public interface BookCategoryDao
{
    List<BookCategoryRecord> findBookCategoriesByBook(BookRecord bookRecord);
}
