package com.bcorp.polaris.author.dao;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;

import java.util.List;
import java.util.Map;

public interface AuthorPageDao
{
    List<PageRecord> findAllPagesByBookAndChapter(BookRecord bookRecord, ChapterRecord chapterRecord);

    Map<Long, List<PageRecord>> findAllPageTitleWithChapterByBook(BookRecord bookRecord);

    void softDelete(PageRecord pageRecord);

    void softDeletePagesByBookAndChapter(BookRecord bookRecord, ChapterRecord chapterRecord);

    PageRecord save(PageRecord pageRecord);
}
