package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.core.dto.BookDto;

import java.util.List;

public interface BookFacade
{
    List<BookDto> getAllBooks();

    BookDto getBookDetail(Long bookId);
}
