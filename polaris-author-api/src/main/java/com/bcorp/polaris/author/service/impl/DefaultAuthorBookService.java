package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.author.service.AuthorUserService;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.core.type.BookStatus;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.model.tables.Book.BOOK;
import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static com.bcorp.polaris.core.model.tables.Page.PAGE;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Service(value = "authorBookService")
public class DefaultAuthorBookService implements AuthorBookService
{
    private DSLContext dslContext;
    private AuthorUserService authorUserService;
    private AuthorPageDao authorPageDao;


    public DefaultAuthorBookService(DSLContext dslContext, AuthorUserService authorUserService, AuthorPageDao authorPageDao)
    {
        this.dslContext = dslContext;
        this.authorUserService = authorUserService;
        this.authorPageDao = authorPageDao;
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

    public BookRecord createNewBook(String title)
    {
        return dslContext.transactionResult(configuration -> {
            final UserRecord currentAuthorUser = authorUserService.getCurrentAuthorUser();
            BookRecord bookRecord = DSL.using(configuration).insertInto(BOOK)
                    .set(BOOK.TITLE, title)
                    .set(BOOK.STATUS, (byte) BookStatus.DRAFT.getValue())
                    .set(BOOK.USER_ID, currentAuthorUser.getId())
                    .returning()
                    .fetchOne();

            final ChapterRecord chapterRecord = DSL.using(configuration).insertInto(CHAPTER)
                    .set(CHAPTER.BOOK_ID, bookRecord.getId())
                    .set(CHAPTER.TITLE, "第一章")
                    .set(CHAPTER.SORT_POSITION, 1)
                    .returning(CHAPTER.ID)
                    .fetchOne();

            DSL.using(configuration).insertInto(PAGE)
                    .set(PAGE.CHAPTER_ID, chapterRecord.getId())
                    .set(PAGE.BOOK_ID, bookRecord.getId())
                    .set(PAGE.USER_ID, currentAuthorUser.getId())
                    .set(PAGE.SORT_POSITION, 1)
                    .execute();
            return bookRecord;
        });
    }
}
