package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.controller.mapper.AuthorRestMapper;
import com.bcorp.polaris.author.dto.CreatePageDto;
import com.bcorp.polaris.author.dto.PageDto;
import com.bcorp.polaris.author.dto.SavePageDto;
import com.bcorp.polaris.author.facade.AuthorPageFacade;
import com.bcorp.polaris.author.model.CreatePageRequest;
import com.bcorp.polaris.author.model.CreatePageResponse;
import com.bcorp.polaris.author.model.SavePageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthorPageController
{
    private AuthorPageFacade authorPageFacade;
    private AuthorRestMapper authorRestMapper;

    @Autowired
    public AuthorPageController(AuthorPageFacade authorPageFacade,
                                AuthorRestMapper authorRestMapper)
    {
        this.authorPageFacade = authorPageFacade;
        this.authorRestMapper = authorRestMapper;
    }

    @PostMapping(path = "/author/api/v1/books/{book_id}/pages")
    public ResponseEntity<CreatePageResponse> createNewPage(
            @Valid @RequestBody CreatePageRequest body,
            @PathVariable(name = "book_id") Long bookId)
    {
        CreatePageDto dto = new CreatePageDto();
        dto.setBookId(bookId);
        dto.setChapterId(body.getChapterId());
        dto.setTitle(body.getTitle());
        dto.setSortPosition(body.getSortPosition());

        final PageDto pageDto = authorPageFacade.createPage(dto);

        CreatePageResponse response = CreatePageResponse.builder()
                .page(authorRestMapper.convert(pageDto))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(path = "/author/api/v1/books/{book_id}/pages/{page_id}/save")
    public ResponseEntity<?> savePage(
            @Valid @RequestBody SavePageRequest body,
            @PathVariable(name = "book_id") Long bookId,
            @PathVariable(name = "page_id") Long pageId
    )
    {
        SavePageDto dto = new SavePageDto();
        dto.setPageId(pageId);
        dto.setBookId(bookId);
        dto.setTitle(body.getTitle());
        dto.setBody(body.getBody());
        dto.setCharacterCount(body.getCharacterCount());

        authorPageFacade.savePage(dto);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
