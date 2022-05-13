package com.bcorp.polaris.author.dao;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;

import java.util.List;

public interface AuthorBookCategoryDao
{
    List<BookCategoryRecord> findAllBookCategories();

    List<BookCategoryRecord> findAllBookCategoriesByIds(List<Long> bookCategoryIds);

    List<BookCategoryRecord> findBookCategoriesByBook(BookRecord bookRecord);
}
