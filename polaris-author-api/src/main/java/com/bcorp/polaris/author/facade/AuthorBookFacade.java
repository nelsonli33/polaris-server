package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.core.dto.BookDto;

import java.util.List;

public interface AuthorBookFacade
{
    BookDto getBookIntro(Long bookId);

    BookDto createNewBook(String title);

    void batchSaveBookCategoryToBook(Long bookId, List<Long> bookCategoryIds);
}
