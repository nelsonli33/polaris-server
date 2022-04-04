package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.author.service.AuthorUserService;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static com.bcorp.polaris.core.model.tables.Page.PAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@JooqTest
class DefaultAuthorBookServiceTest
{
    private DefaultAuthorBookService defaultAuthorBookService;
    @Autowired
    private DSLContext dslContext;
    @MockBean
    private AuthorUserService authorUserService;
    @MockBean
    private AuthorPageDao authorPageDao;

    @BeforeEach
    void setUp()
    {
        defaultAuthorBookService = new DefaultAuthorBookService(dslContext, authorUserService, authorPageDao);
    }

    @Test
    void testCreateNewBook()
    {
        // given
        String fakeTitle = "Best New Book In The World";
        UserRecord dummyUser = new UserRecord();
        dummyUser.setId(1L);
        given(authorUserService.getCurrentAuthorUser()).willReturn(dummyUser);

        // when
        final BookRecord newBook = defaultAuthorBookService.createNewBook(fakeTitle);

        // then
        assertEquals(fakeTitle, newBook.getTitle());

        ChapterRecord chapter = dslContext.fetchOne(CHAPTER, CHAPTER.BOOK_ID.eq(newBook.getId()));
        assertNotNull(chapter);
        assertEquals(chapter.getTitle(), "第一章");

        final PageRecord page = dslContext.fetchOne(PAGE, PAGE.CHAPTER_ID.eq(chapter.getId()));
        assertNotNull(page);
    }

}