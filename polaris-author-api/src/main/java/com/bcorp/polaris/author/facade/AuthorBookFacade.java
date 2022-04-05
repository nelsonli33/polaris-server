package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.author.dto.BookDto;

import java.util.List;

public interface AuthorBookFacade
{
    BookDto getBookIntro(Long bookId);

    BookDto createNewBook(String title);

    void batchSaveBookCategoryToBook(Long bookId, List<Long> bookCategoryIds);
}
