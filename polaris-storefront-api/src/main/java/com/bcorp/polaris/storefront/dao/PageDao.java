package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;

import java.util.List;
import java.util.Map;

public interface PageDao
{
    Map<ChapterRecord, List<PageRecord>> findAllPageRecordsGroupByChapterByBookId(Long bookId);
}
