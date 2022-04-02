package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.author.service.AuthorUserService;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.core.type.BookStatus;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import static com.bcorp.polaris.core.model.tables.Book.BOOK;
import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static com.bcorp.polaris.core.model.tables.Page.PAGE;

@Service(value = "authorBookService")
public class DefaultAuthorBookService implements AuthorBookService
{
    private DSLContext dslContext;
    private AuthorUserService authorUserService;


    public DefaultAuthorBookService(DSLContext dslContext, AuthorUserService authorUserService)
    {
        this.dslContext = dslContext;
        this.authorUserService = authorUserService;
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
                    .set(PAGE.SORT_POSITION, 1)
                    .execute();
            return bookRecord;
        });
    }
}
