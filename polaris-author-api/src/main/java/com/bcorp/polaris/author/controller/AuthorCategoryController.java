package com.bcorp.polaris.author.controller;

import com.bcorp.polaris.author.api.model.GetCategoryTreeResponse;
import com.bcorp.polaris.author.facade.AuthorBookCategoryFacade;
import com.bcorp.polaris.core.dto.BookCategoryTreeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorCategoryController extends AbstractAuthorController
{
    private AuthorBookCategoryFacade authorBookCategoryFacade;

    public AuthorCategoryController(AuthorBookCategoryFacade authorBookCategoryFacade)
    {
        this.authorBookCategoryFacade = authorBookCategoryFacade;
    }

    @GetMapping(path = "/author/api/v1/categories/category-tree")
    public ResponseEntity<GetCategoryTreeResponse> getCategoriesTree()
    {
        final List<BookCategoryTreeDto> categoryTree = authorBookCategoryFacade.getCategoryTree();

        GetCategoryTreeResponse response = GetCategoryTreeResponse.builder()
                .categories(getAuthorRestMapper().convert(categoryTree))
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
