package com.bcorp.polaris.storefront.dao.service;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.storefront.bo.BookBo;

import java.util.List;
import java.util.Map;

public interface BookService
{
    List<BookRecord> getAllBooks();

    BookRecord getBookForId(Long bookId);

    BookBo getBookAndAuthorForId(Long bookId);

    Map<ChapterRecord, List<PageRecord>> getTableOfContent(Long bookId);

    BookBo getBookBo(BookRecord bookRecord);
}
