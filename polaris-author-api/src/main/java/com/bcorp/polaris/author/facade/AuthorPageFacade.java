package com.bcorp.polaris.author.facade;

import com.bcorp.polaris.core.dto.CreatePageDto;
import com.bcorp.polaris.core.dto.PageDto;
import com.bcorp.polaris.core.dto.SavePageDto;

public interface AuthorPageFacade
{
    PageDto getPage(Long pageId);

    PageDto createPage(CreatePageDto createPageDto);

    PageDto savePage(SavePageDto savePageDto);

    void deletePage(Long pageId);
}
