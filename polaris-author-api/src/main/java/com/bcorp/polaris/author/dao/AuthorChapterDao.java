package com.bcorp.polaris.author.dao;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;

import java.util.List;

public interface AuthorChapterDao
{

    List<ChapterRecord> findAllChaptersByBook(BookRecord bookRecord);

    int countChaptersByBook(BookRecord bookRecord);

    ChapterRecord saveChapter(ChapterRecord chapter);
    
    void moveBackwardAfterChapterSortPos(BookRecord bookRecord, int sortPosition);
}
