package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorChapterDao;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.bcorp.polaris.core.model.tables.Chapter.CHAPTER;
import static org.mockito.BDDMockito.given;

class DefaultAuthorChapterServiceTest
{
    private DefaultAuthorChapterService defaultAuthorBookService;
    @Mock
    private DSLContext dslContext;
    @Mock
    private AuthorChapterDao authorChapterDao;
    @Mock
    private ChapterRecord dummyChapter;


    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        defaultAuthorBookService = new DefaultAuthorChapterService(dslContext, authorChapterDao);
        dummyChapter = new ChapterRecord();
        dummyChapter.setId(20L);
        dummyChapter.setTitle("ssss");
    }

    @Test
    void testCreateChapter()
    {
        // given
        String title = "Fake title";
        BookRecord dummyBook = new BookRecord();
        dummyBook.setId(1L);
        given(dslContext.newRecord(CHAPTER)).willReturn(dummyChapter);
        // when
        defaultAuthorBookService.createChapter(dummyBook, title, null);

        // then
        InOrder inOrder = Mockito.inOrder(authorChapterDao);
        inOrder.verify(authorChapterDao).moveBackwardAfterChapterSortPos(dummyBook, 0);
        inOrder.verify(authorChapterDao).saveChapter(dummyChapter);
    }
}