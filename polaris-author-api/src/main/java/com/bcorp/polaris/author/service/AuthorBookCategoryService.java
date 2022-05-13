package com.bcorp.polaris.author.service;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;

import java.util.List;

public interface AuthorBookCategoryService
{
    List<BookCategoryRecord> getAllBookCategories();

    List<BookCategoryRecord> getBookCategoriesForIds(List<Long> bookCategoryIds);

    List<BookCategoryRecord> getBookCategoriesForBook(BookRecord bookRecord);
}
