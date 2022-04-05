package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.controller.mapper.AuthorRestMapper;
import com.bcorp.polaris.author.dto.BookDto;
import com.bcorp.polaris.author.facade.AuthorBookFacade;
import com.bcorp.polaris.author.model.BatchSaveBookCategoryToBookRequest;
import com.bcorp.polaris.author.model.CreateBookRequest;
import com.bcorp.polaris.author.model.CreateBookResponse;
import com.bcorp.polaris.author.model.GetBookIntroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/author/api/v1/books/{book_id}")
    public ResponseEntity<GetBookIntroResponse> getBookIntro(@PathVariable(name = "book_id") Long bookId)
    {
        final BookDto bookIntroDto = authorBookFacade.getBookIntro(bookId);
        final GetBookIntroResponse response = GetBookIntroResponse
                .builder()
                .book(authorRestMapper.convert(bookIntroDto))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
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

    @PutMapping(path = "/author/api/v1/books/{book_id}/categories/batch-save")
    public ResponseEntity<?> batchSaveBookCategoriesToBook(
            @Valid @RequestBody BatchSaveBookCategoryToBookRequest body,
            @PathVariable(name = "book_id") Long bookId)
    {
        authorBookFacade.batchSaveBookCategoryToBook(bookId, body.getBookCategoryIds());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
