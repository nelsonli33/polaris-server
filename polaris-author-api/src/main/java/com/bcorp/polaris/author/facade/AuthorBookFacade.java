package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.author.dto.UpdateBookDto;
import com.bcorp.polaris.core.dto.BookDto;

import java.util.List;

public interface AuthorBookFacade
{
    BookDto getBookIntro(Long bookId);

    Long createNewBook(String title, List<Long> categoryIds);

    Long updateBook(Long bookId, UpdateBookDto updateBookDto);

    void batchSaveBookCategoryForBookId(Long bookId, List<Long> bookCategoryIds);
}
