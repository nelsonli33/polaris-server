package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.author.dto.BookDto;

public interface AuthorBookFacade
{
    BookDto getBookIntro(Long bookId);

    BookDto createNewBook(String title);
}
