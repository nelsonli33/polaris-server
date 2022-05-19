package com.bcorp.polaris.author.dao;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;

import java.util.List;

public interface AuthorChapterDao
{

    List<ChapterRecord> findAllChaptersByBook(BookRecord bookRecord);

    ChapterRecord saveChapter(ChapterRecord chapter);
    
    int countChaptersByBook(BookRecord bookRecord);

    void softDelete(ChapterRecord chapter);
}
