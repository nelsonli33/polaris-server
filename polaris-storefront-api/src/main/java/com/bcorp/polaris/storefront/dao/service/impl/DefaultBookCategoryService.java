package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.storefront.dao.BookCategoryDao;
import com.bcorp.polaris.storefront.dao.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Service(value = "bookCategoryService")
public class DefaultBookCategoryService implements BookCategoryService
{
    private BookCategoryDao bookCategoryDao;

    @Autowired
    public DefaultBookCategoryService(BookCategoryDao bookCategoryDao)
    {
        this.bookCategoryDao = bookCategoryDao;
    }

    @Override
    public List<BookCategoryRecord> getBookCategoriesForBook(BookRecord bookRecord)
    {
        validateParameterNotNull(bookRecord, "bookRecord must not be null");
        return bookCategoryDao.findBookCategoriesByBook(bookRecord);
    }
}
