package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.dto.BookDto;
import com.bcorp.polaris.storefront.api.model.GetBookIntroResponse;
import com.bcorp.polaris.storefront.facade.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController extends AbstractController
{
    private BookFacade bookFacade;

    @Autowired
    public BookController(BookFacade bookFacade)
    {
        this.bookFacade = bookFacade;
    }

    @GetMapping(path = "/api/v1/books/{book_id}/intro")
    public ResponseEntity<GetBookIntroResponse> getBookIntroResponse(@PathVariable(name = "book_id") Long bookId)
    {
        final BookDto bookIntro = bookFacade.getBookIntro(bookId);

        GetBookIntroResponse response = GetBookIntroResponse.builder()
                .book(getStorefrontRestMapper().convert(bookIntro))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
