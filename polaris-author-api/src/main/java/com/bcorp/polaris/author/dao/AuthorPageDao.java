package com.bcorp.polaris.author.dao;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;

import java.util.List;
import java.util.Map;

public interface AuthorPageDao
{
    Map<Long, List<PageRecord>> findAllPageTitleWithChapterByBook(BookRecord bookRecord);

    PageRecord save(PageRecord pageRecord);
}
