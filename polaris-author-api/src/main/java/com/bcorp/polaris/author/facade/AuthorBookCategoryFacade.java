package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.core.dto.BookCategoryTreeDto;

import java.util.List;

public interface AuthorBookCategoryFacade
{
    List<BookCategoryTreeDto> getCategoryTree();
}
