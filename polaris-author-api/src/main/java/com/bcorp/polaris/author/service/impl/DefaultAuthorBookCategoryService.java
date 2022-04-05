package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.dao.AuthorBookCategoryDao;
import com.bcorp.polaris.author.service.AuthorBookCategoryService;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "authorBookCategoryService")
public class DefaultAuthorBookCategoryService implements AuthorBookCategoryService
{
    private AuthorBookCategoryDao authorBookCategoryDao;

    @Autowired
    public DefaultAuthorBookCategoryService(AuthorBookCategoryDao authorBookCategoryDao)
    {
        this.authorBookCategoryDao = authorBookCategoryDao;
    }

    public List<BookCategoryRecord> getBookCategoriesForIds(List<Long> bookCategoryIds)
    {

        final List<BookCategoryRecord> bookCategoryRecords
                = authorBookCategoryDao.findAllBookCategoriesByIds(bookCategoryIds);

        if (CollectionUtils.isEmpty(bookCategoryRecords))
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.RECORD_NOT_FOUND, "Book with ids: " + StringUtils.join(bookCategoryIds, ',') + " not found.");
        }

        return bookCategoryRecords;
    }
}
