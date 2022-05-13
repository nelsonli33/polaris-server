package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorChapterDao;
import com.bcorp.polaris.author.service.AuthorChapterService;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Service(value = "authorChapterService")
public class DefaultAuthorChapterService implements AuthorChapterService
{
    private static final int MAXIMUM_CHAPTER_COUNT = 20;

    private DSLContext dslContext;
    private AuthorChapterDao authorChapterDao;

    public DefaultAuthorChapterService(DSLContext dslContext, AuthorChapterDao authorChapterDao)
    {
        this.dslContext = dslContext;
        this.authorChapterDao = authorChapterDao;
    }

    public ChapterRecord getChapterForId(BookRecord bookRecord, Long chapterId)
    {
        validateParameterNotNull(bookRecord, "BookRecord must not be null");
        validateParameterNotNull(chapterId, "ChapterId must not be null");

        final ChapterRecord chapterRecord = dslContext.fetchOne(CHAPTER, CHAPTER.ID.eq(chapterId).and(CHAPTER.BOOK_ID.eq(bookRecord.getId())));
        if (chapterRecord == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.RECORD_NOT_FOUND, "Chapter: " + chapterId + "not found.");
        }
        return chapterRecord;
    }

    public List<ChapterRecord> getAllChaptersForBook(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");
        return authorChapterDao.findAllChaptersByBook(bookRecord);
    }

    @Override
    public void validateAddChapterIsValid(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");
        final int chaptersCount = authorChapterDao.countChaptersByBook(bookRecord);
        if (chaptersCount >= MAXIMUM_CHAPTER_COUNT)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.Exceed_MAXIMUM_CHAPTER_COUNT, "最多 " + MAXIMUM_CHAPTER_COUNT + " 章節");
        }
    }

    // TODO: add unit test
    @Transactional
    public ChapterRecord createChapter(BookRecord bookRecord, String title, ChapterRecord belowChapterRecord)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");

        int sortPos = belowChapterRecord == null ? 0 : belowChapterRecord.getSortPosition();
        authorChapterDao.moveBackwardAfterChapterSortPos(bookRecord, sortPos);

        int newSortPosition = belowChapterRecord == null ? 1 : belowChapterRecord.getSortPosition() + 1;
        final ChapterRecord newChapter = dslContext.newRecord(CHAPTER);
        newChapter.setTitle(title);
        newChapter.setBookId(bookRecord.getId());
        newChapter.setSortPosition(newSortPosition);
        return authorChapterDao.saveChapter(newChapter);
    }

    @Override
    public ChapterRecord updateChapter(ChapterRecord chapterRecord, String title)
    {
        validateParameterNotNull(chapterRecord, "ChapterRecord must not be null");
        chapterRecord.setTitle(title);
        return authorChapterDao.saveChapter(chapterRecord);
    }
}
