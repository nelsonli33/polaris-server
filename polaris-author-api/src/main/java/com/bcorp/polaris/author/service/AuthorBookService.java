package com.bcorp.polaris.author.service;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;

import java.util.List;
import java.util.Map;

public interface AuthorBookService
{
    BookRecord getBookForId(Long bookId);

    Map<Long, List<PageRecord>> getTableOfContent(BookRecord bookRecord);

    BookRecord createNewBook(String title, List<BookCategoryRecord> bookCategoryRecords);

    void batchSaveBookCategoriesToBook(BookRecord bookRecord, List<BookCategoryRecord> bookCategoryRecords);
}
