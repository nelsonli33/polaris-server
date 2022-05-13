package com.bcorp.polaris.author.facade.impl;

import com.bcorp.polaris.author.facade.AuthorBookCategoryFacade;
import com.bcorp.polaris.author.service.AuthorBookCategoryService;
import com.bcorp.polaris.core.dto.BookCategoryTreeDto;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(value = "authorBookCategoryFacade")
public class DefaultAuthorBookCategoryFacade
        implements AuthorBookCategoryFacade
{
    private AuthorBookCategoryService authorBookCategoryService;

    public DefaultAuthorBookCategoryFacade(AuthorBookCategoryService authorBookCategoryService)
    {
        this.authorBookCategoryService = authorBookCategoryService;
    }

    @Override
    public List<BookCategoryTreeDto> getCategoryTree()
    {
        final List<BookCategoryRecord> allBookCategories = authorBookCategoryService.getAllBookCategories();
        Map<Long, BookCategoryTreeDto> map = allBookCategories.stream().collect(Collectors.toMap(BookCategoryRecord::getId,
                cat -> BookCategoryTreeDto.builder()
                        .id(cat.getId())
                        .name(cat.getName())
                        .parentId(cat.getParentId())
                        .children(new ArrayList<>())
                        .build()));

        List<BookCategoryTreeDto> treeRoot = new ArrayList<>();
        allBookCategories.forEach(cat -> {
            final BookCategoryTreeDto node = map.get(cat.getId());
            if (cat.getParentId() != null)
            {
                final BookCategoryTreeDto parent = map.get(cat.getParentId());
                parent.getChildren().add(node);
            }
            else
            {
                treeRoot.add(node);
            }
        });
        return treeRoot;
    }
}
