package com.bcorp.polaris.author.service;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;

import java.util.List;

public interface AuthorChapterService
{
    ChapterRecord getChapterForId(BookRecord bookRecord, Long chapterId);

    List<ChapterRecord> getAllChaptersForBook(BookRecord bookRecord);

    void validateAddChapterIsValid(BookRecord bookRecord);

    ChapterRecord createChapter(BookRecord bookRecord, String title, ChapterRecord belowChapterRecord);

    ChapterRecord updateChapter(ChapterRecord chapterRecord, String title);
}
