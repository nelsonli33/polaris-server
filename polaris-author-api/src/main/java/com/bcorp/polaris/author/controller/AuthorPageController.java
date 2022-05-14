package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.api.model.*;
import com.bcorp.polaris.author.facade.AuthorPageFacade;
import com.bcorp.polaris.core.dto.CreatePageDto;
import com.bcorp.polaris.core.dto.PageDto;
import com.bcorp.polaris.core.dto.SavePageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AuthorPageController extends AbstractAuthorController
{
    private AuthorPageFacade authorPageFacade;

    @Autowired
    public AuthorPageController(AuthorPageFacade authorPageFacade)
    {
        this.authorPageFacade = authorPageFacade;
    }


    // Creates a new page for a book
    @PostMapping(path = "/author/api/v1/pages")
    public ResponseEntity<CreatePageResponse> createNewPage(
            @Valid @RequestBody CreatePageRequest body
    )
    {
        CreatePageDto dto = new CreatePageDto();
        dto.setBookId(body.getBookId());
        dto.setChapterId(body.getChapterId());
        dto.setTitle(body.getTitle());
        dto.setSortPosition(body.getSortPosition());

        final PageDto pageDto = authorPageFacade.createPage(dto);

        CreatePageResponse response = CreatePageResponse.builder()
                .page(getAuthorRestMapper().convert(pageDto))
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Retrieves a single page
    @GetMapping(path = "/author/api/v1/pages/{page_id}")
    public ResponseEntity<GetPageResponse> getPage(
            @PathVariable(name = "page_id") Long pageId
    )
    {
        final PageDto pageDto = authorPageFacade.getPage(pageId);

        GetPageResponse response = GetPageResponse.builder()
                .page(getAuthorRestMapper().convert(pageDto))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PutMapping(path = "/author/api/v1/pages/{page_id}/save")
    public ResponseEntity<SavePageResponse> savePage(
            @Valid @RequestBody SavePageRequest body,
            @PathVariable(name = "page_id") Long pageId
    )
    {

        SavePageDto dto = new SavePageDto();
        dto.setPageId(pageId);
        dto.setTitle(body.getTitle());
        dto.setDescription(body.getDescription());
        dto.setBody(body.getBody());
        dto.setCharacterCount(body.getCharacterCount());

        final PageDto pageDto = authorPageFacade.savePage(dto);

        SavePageResponse response = SavePageResponse.builder()
                .page(getAuthorRestMapper().convert(pageDto))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
