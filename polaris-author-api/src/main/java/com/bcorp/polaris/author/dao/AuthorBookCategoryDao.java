package com.bcorp.polaris.author.dao;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;

import java.util.List;

public interface AuthorBookCategoryDao
{
    List<BookCategoryRecord> findAllBookCategoriesByIds(List<Long> bookCategoryIds);
}
