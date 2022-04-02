package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.controller.mapper.AuthorRestMapper;
import com.bcorp.polaris.author.dto.BookDto;
import com.bcorp.polaris.author.facade.AuthorBookFacade;
import com.bcorp.polaris.author.model.CreateBookRequest;
import com.bcorp.polaris.author.model.CreateBookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthorBookController
{
    private AuthorBookFacade authorBookFacade;
    private AuthorRestMapper authorRestMapper;

    public AuthorBookController(AuthorBookFacade authorBookFacade,
                                AuthorRestMapper authorRestMapper)
    {
        this.authorBookFacade = authorBookFacade;
        this.authorRestMapper = authorRestMapper;
    }

    @PostMapping(path = "/author/api/v1/books")
    public ResponseEntity<CreateBookResponse> createBook(@Valid @RequestBody CreateBookRequest body)
    {
        final BookDto newBookDto = authorBookFacade.createNewBook(body.getTitle());
        final CreateBookResponse response = CreateBookResponse
                .builder()
                .book(authorRestMapper.convert(newBookDto))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
