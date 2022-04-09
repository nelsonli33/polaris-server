package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import org.jooq.Record;

import java.util.List;
import java.util.Map;

public interface BookService
{
    BookRecord getBookForId(Long bookId);

    Record getBookAndAuthorForId(Long bookId);

    Map<ChapterRecord, List<PageRecord>> getTableOfContent(Long bookId);

    BookBo getBookBo(BookRecord bookRecord);
}
