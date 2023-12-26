package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.dto.BookDto;
import com.bcorp.polaris.storefront.api.model.GetAllBooksResponse;
import com.bcorp.polaris.storefront.api.model.GetBookDetailResponse;
import com.bcorp.polaris.storefront.facade.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController extends AbstractController
{
    private BookFacade bookFacade;

    @Autowired
    public BookController(BookFacade bookFacade)
    {
        this.bookFacade = bookFacade;
    }

    @GetMapping(path = "/api/v1/books")
    public ResponseEntity<GetAllBooksResponse> getBookList()
    {
        final List<BookDto> allBooks = bookFacade.getAllBooks();

        GetAllBooksResponse response = GetAllBooksResponse.builder()
                .books(getStorefrontRestMapper().convertList(allBooks))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(path = "/api/v1/books/{book_id}/detail")
    public ResponseEntity<GetBookDetailResponse> getBookDetailResponse(@PathVariable(name = "book_id") Long bookId)
    {
        final BookDto bookDetail = bookFacade.getBookDetail(bookId);

        GetBookDetailResponse response = GetBookDetailResponse.builder()
                .book(getStorefrontRestMapper().convert(bookDetail))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
