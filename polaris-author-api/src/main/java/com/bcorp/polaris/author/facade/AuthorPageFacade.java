package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.author.dto.CreatePageDto;
import com.bcorp.polaris.author.dto.PageDto;
import com.bcorp.polaris.author.dto.SavePageDto;

public interface AuthorPageFacade
{
    PageDto createPage(CreatePageDto createPageDto);

    void savePage(SavePageDto savePageDto);
}
