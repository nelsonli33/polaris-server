package com.bcorp.polaris.author.service;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;

public interface AuthorPageService
{
    PageRecord getPageForId(Long pageId);

    PageRecord createPage(PageRecord pageRecord, BookRecord bookRecord, ChapterRecord chapterRecord);
}
