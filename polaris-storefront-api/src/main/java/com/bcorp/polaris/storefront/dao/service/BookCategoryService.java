package com.bcorp.polaris.storefront.dao.service;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;

import java.util.List;

public interface BookCategoryService
{
    List<BookCategoryRecord> getBookCategoriesForBook(BookRecord bookRecord);
}
