package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorPageDao;
import com.bcorp.polaris.author.service.AuthorBookCategoryService;
import com.bcorp.polaris.author.service.AuthorUserService;
import com.bcorp.polaris.author.service.LexoRankService;
import com.bcorp.polaris.core.model.tables.records.*;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

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
    private AuthorBookCategoryService authorBookCategoryService;
    @MockBean
    private AuthorPageDao authorPageDao;
    @MockBean
    private LexoRankService lexoRankService;

    @BeforeEach
    void setUp()
    {
        defaultAuthorBookService = new DefaultAuthorBookService(dslContext, authorUserService, authorPageDao, lexoRankService);
    }

    @Test
    void testCreateNewBook()
    {
        // given
        String fakeTitle = "Best New Book In The World";
        UserRecord dummyUser = new UserRecord();
        dummyUser.setId(1L);
        given(authorUserService.getCurrentAuthorUser()).willReturn(dummyUser);

        BookCategoryRecord dummyBookCategory = new BookCategoryRecord();
        dummyBookCategory.setId(1L);
        given(authorBookCategoryService.getBookCategoriesForIds(List.of(1L))).willReturn(List.of(dummyBookCategory));

        given(lexoRankService.getInitialRank()).willReturn("0|hzzzzz:");
        // when
        final BookRecord newBook = defaultAuthorBookService.createNewBook(fakeTitle, List.of(dummyBookCategory));

        // then
        assertEquals(fakeTitle, newBook.getTitle());

        ChapterRecord chapter = dslContext.fetchOne(CHAPTER, CHAPTER.BOOK_ID.eq(newBook.getId()));
        assertNotNull(chapter);
        assertEquals(chapter.getTitle(), "第一章");

        final PageRecord page = dslContext.fetchOne(PAGE, PAGE.CHAPTER_ID.eq(chapter.getId()));
        assertNotNull(page);
    }

}