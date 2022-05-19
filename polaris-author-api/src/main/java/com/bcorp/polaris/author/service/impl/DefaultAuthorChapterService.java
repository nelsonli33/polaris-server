package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorChapterDao;
import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.author.service.AuthorChapterService;
import com.bcorp.polaris.author.service.LexoRankService;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import org.jooq.DSLContext;
import org.jooq.tools.StringUtils;
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

    private AuthorPageDao authorPageDao;

    private LexoRankService lexoRankService;

    public DefaultAuthorChapterService(DSLContext dslContext,
                                       AuthorChapterDao authorChapterDao,
                                       AuthorPageDao authorPageDao,
                                       LexoRankService lexoRankService)
    {
        this.dslContext = dslContext;
        this.authorChapterDao = authorChapterDao;
        this.authorPageDao = authorPageDao;
        this.lexoRankService = lexoRankService;
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
    public ChapterRecord createChapter(BookRecord bookRecord, String title, Long beforeChapterId, Long afterChapterId)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");
        final ChapterRecord newChapter = dslContext.newRecord(CHAPTER);
        newChapter.setTitle(title);
        newChapter.setBookId(bookRecord.getId());
        newChapter.setRank(genNewRank(bookRecord, beforeChapterId, afterChapterId));
        return authorChapterDao.saveChapter(newChapter);
    }

    protected String genNewRank(BookRecord bookRecord, Long beforeChapterId, Long afterChapterId)
    {
        String rank = "";

        if (beforeChapterId == null && afterChapterId == null)
        {
            rank = lexoRankService.getInitialRank();
        }
        else if (beforeChapterId != null && afterChapterId == null)
        {
            final ChapterRecord beforeChapter = getChapterForId(bookRecord, beforeChapterId);
            rank = lexoRankService.getNextRank(beforeChapter.getRank());
        }
        else if (beforeChapterId == null && afterChapterId != null)
        {
            final ChapterRecord afterChapter = getChapterForId(bookRecord, afterChapterId);
            rank = lexoRankService.getPrevRank(afterChapter.getRank());
        }
        else
        {
            final ChapterRecord beforeChapter = getChapterForId(bookRecord, beforeChapterId);
            final ChapterRecord afterChapter = getChapterForId(bookRecord, afterChapterId);
            rank = lexoRankService.getBetweenRank(beforeChapter.getRank(), afterChapter.getRank());
        }

        if (StringUtils.isEmpty(rank))
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, "Generate new rank for chapter failed.");
        }

        return rank;
    }

    @Override
    public ChapterRecord updateChapter(ChapterRecord chapterRecord, String title)
    {
        validateParameterNotNull(chapterRecord, "ChapterRecord must not be null");
        chapterRecord.setTitle(title);
        return authorChapterDao.saveChapter(chapterRecord);
    }

    @Override
    public void deleteChapter(BookRecord bookRecord, ChapterRecord chapterRecord, boolean softDelete)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");
        validateParameterNotNull(chapterRecord, "ChapterRecord must not be null");
        if (softDelete)
        {
            authorPageDao.softDeletePagesByBookAndChapter(bookRecord, chapterRecord);
            authorChapterDao.softDelete(chapterRecord);
        }
        else
        {
            final List<PageRecord> pages = authorPageDao.findAllPagesByBookAndChapter(bookRecord, chapterRecord);
            dslContext.batchDelete(pages).execute();
            chapterRecord.delete();
        }
    }
}
