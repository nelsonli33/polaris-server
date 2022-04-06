package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.core.dto.BookDto;

public interface BookFacade
{
    BookDto getBookIntro(Long bookId);
}
