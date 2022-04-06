package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import org.jooq.Record;

import java.util.List;
import java.util.Map;

public interface BookService
{
    Record getBookForId(Long bookId);

    Map<ChapterRecord, List<PageRecord>> getTableOfContent(Long bookId);
}
