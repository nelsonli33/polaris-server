package com.bcorp.polaris.author.facade.impl;

import com.bcorp.polaris.author.dto.BookDto;
import com.bcorp.polaris.author.facade.AuthorBookFacade;
import com.bcorp.polaris.author.service.AuthorBookService;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "authorBookFacade")
public class DefaultAuthorBookFacade implements AuthorBookFacade
{
    private AuthorBookService authorBookService;

    @Autowired
    public DefaultAuthorBookFacade(AuthorBookService authorBookService)
    {
        this.authorBookService = authorBookService;
    }

    @Override
    public BookDto createNewBook(String title)
    {
        final BookRecord newBook = authorBookService.createNewBook(title);

        final BookDto bookDto = newBook.into(BookDto.class);
        
        return bookDto;
    }
}
