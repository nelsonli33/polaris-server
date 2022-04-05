package com.bcorp.polaris.author.service;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;

import java.util.List;

public interface AuthorBookCategoryService
{
    List<BookCategoryRecord> getBookCategoriesForIds(List<Long> bookCategoryIds);
}
