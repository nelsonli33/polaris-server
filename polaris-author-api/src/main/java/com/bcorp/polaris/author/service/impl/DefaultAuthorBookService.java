package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.author.service.AuthorUserService;
import com.bcorp.polaris.author.service.LexoRankService;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.*;
import com.bcorp.polaris.core.type.BookStatus;
import org.jooq.DSLContext;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.model.tables.Book.BOOK;
import static com.bcorp.polaris.core.model.tables.BookCategoryRel.BOOK_CATEGORY_REL;
import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static com.bcorp.polaris.core.model.tables.Page.PAGE;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Service(value = "authorBookService")
public class DefaultAuthorBookService implements AuthorBookService
{
    private DSLContext dslContext;
    private AuthorUserService authorUserService;
    private AuthorPageDao authorPageDao;

    private LexoRankService lexoRankService;


    public DefaultAuthorBookService(DSLContext dslContext,
                                    AuthorUserService authorUserService,
                                    AuthorPageDao authorPageDao,
                                    LexoRankService lexoRankService)
    {
        this.dslContext = dslContext;
        this.authorUserService = authorUserService;
        this.authorPageDao = authorPageDao;
        this.lexoRankService = lexoRankService;
    }

    @Override
    public List<BookRecord> getBookList(Pageable pageable)
    {
        final UserRecord currentAuthorUser = authorUserService.getCurrentAuthorUser();

        return dslContext.select().from(BOOK)
                .where(BOOK.USER_ID.eq(currentAuthorUser.getId()))
                .orderBy(BOOK.PUBLISHED_AT.desc(), BOOK.CREATED_AT.desc())
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetchInto(BookRecord.class);
    }

    public BookRecord getBookForId(Long bookId)
    {
        validateParameterNotNull(bookId, "Book: " + bookId + " must not be null");
        final UserRecord currentAuthorUser = authorUserService.getCurrentAuthorUser();
        final BookRecord bookRecord =
                dslContext.fetchOne(BOOK, BOOK.ID.eq(bookId).and(BOOK.USER_ID.eq(currentAuthorUser.getId())));
        if (bookRecord == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.RECORD_NOT_FOUND, "Book: " + bookId + "not found");
        }
        return bookRecord;
    }

    public Map<Long, List<PageRecord>> getTableOfContent(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "bookRecord " + bookRecord + " must not be null");
        return authorPageDao.findAllPageTitleWithChapterByBook(bookRecord);
    }

    @Transactional
    public BookRecord createNewBook(String title, List<BookCategoryRecord> bookCategoryRecords)
    {

        final UserRecord currentAuthorUser = authorUserService.getCurrentAuthorUser();
        BookRecord bookRecord = dslContext.insertInto(BOOK)
                .set(BOOK.TITLE, title)
                .set(BOOK.STATUS, (byte) BookStatus.DRAFT.getValue())
                .set(BOOK.USER_ID, currentAuthorUser.getId())
                .returning()
                .fetchOne();

        batchSaveBookCategoriesToBook(bookRecord, bookCategoryRecords);

        final ChapterRecord chapterRecord = dslContext.insertInto(CHAPTER)
                .set(CHAPTER.BOOK_ID, bookRecord.getId())
                .set(CHAPTER.TITLE, "第一章")
                .set(CHAPTER.RANK, lexoRankService.getInitialRank())
                .returning(CHAPTER.ID)
                .fetchOne();

        dslContext.insertInto(PAGE)
                .set(PAGE.CHAPTER_ID, chapterRecord.getId())
                .set(PAGE.BOOK_ID, bookRecord.getId())
                .set(PAGE.USER_ID, currentAuthorUser.getId())
                .set(PAGE.RANK, lexoRankService.getInitialRank())
                .execute();

        return bookRecord;
    }

    ;


    public void batchSaveBookCategoriesToBook(BookRecord bookRecord, List<BookCategoryRecord> bookCategoryRecords)
    {
        validateParameterNotNull(bookRecord, "BookRecord " + bookRecord + " must not be null");

        clearBookCategoryRelForBook(bookRecord);

        List<BookCategoryRelRecord> bcls = new ArrayList<>();
        for (BookCategoryRecord bc : bookCategoryRecords)
        {
            final BookCategoryRelRecord bcl
                    = dslContext.newRecord(BOOK_CATEGORY_REL);
            bcl.setBookId(bookRecord.getId());
            bcl.setBookCategoryId(bc.getId());
            bcls.add(bcl);
        }
        dslContext.batchInsert(bcls).execute();
    }

    private void clearBookCategoryRelForBook(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "BookRecord " + bookRecord + " must not be null");
        dslContext.deleteFrom(BOOK_CATEGORY_REL)
                .where(BOOK_CATEGORY_REL.BOOK_ID.eq(bookRecord.getId()))
                .execute();
    }
}
