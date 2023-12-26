package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.api.model.*;
import com.bcorp.polaris.author.dto.UpdateBookDto;
import com.bcorp.polaris.author.facade.AuthorBookFacade;
import com.bcorp.polaris.core.dto.BookDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class AuthorBookController extends AbstractAuthorController
{
    private AuthorBookFacade authorBookFacade;


    public AuthorBookController(AuthorBookFacade authorBookFacade)
    {
        this.authorBookFacade = authorBookFacade;
    }

    @GetMapping(path = "/author/api/v1/books")
    public ResponseEntity<GetBookListResponse> getBookList(
            @RequestParam(name = "page", defaultValue = "1") @Min(value = 1, message = "Page must not be less than zero!") int page,
            @RequestParam(name = "limit", defaultValue = "25") int limit
    )
    {
        final PageRequest pageRequest = PageRequest.of(page - 1, limit);
        final List<BookDto> bookList = authorBookFacade.getBookList(pageRequest);

        GetBookListResponse response = GetBookListResponse
                .builder()
                .books(getAuthorRestMapper().convertList(bookList))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/author/api/v1/books/{book_id}")
    public ResponseEntity<GetBookIntroResponse> getBookIntro(@PathVariable(name = "book_id") Long bookId)
    {
        final BookDto bookIntroDto = authorBookFacade.getBookIntro(bookId);
        final GetBookIntroResponse response = GetBookIntroResponse
                .builder()
                .book(getAuthorRestMapper().convert(bookIntroDto))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }

    @PostMapping(path = "/author/api/v1/books")
    public ResponseEntity<CreateBookResponse> createBook(@Valid @RequestBody CreateBookRequest body)
    {
        final Long newBookId = authorBookFacade.createNewBook(body.getTitle(), body.getCategoryIds());
        final CreateBookResponse response = CreateBookResponse
                .builder()
                .bookId(newBookId)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(path = "/author/api/v1/books/{book_id}")
    public ResponseEntity<UpdateBookResponse> updateBook(@PathVariable(name = "book_id") Long bookId,
                                                         @Valid @RequestBody UpdateBookRequest body)
    {
        final UpdateBookDto updateBookDto = getAuthorRestMapper().toDto(body);
        final Long updatedBookId = authorBookFacade.updateBook(bookId, updateBookDto);
        final UpdateBookResponse response = UpdateBookResponse.builder()
                .bookId(updatedBookId)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping(path = "/author/api/v1/books/{book_id}/categories/batch-save")
    public ResponseEntity<?> batchSaveBookCategoriesToBook(
            @PathVariable(name = "book_id") Long bookId,
            @Valid @RequestBody BatchSaveBookCategoryToBookRequest body
    )
    {
        authorBookFacade.batchSaveBookCategoryForBookId(bookId, body.getBookCategoryIds());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
