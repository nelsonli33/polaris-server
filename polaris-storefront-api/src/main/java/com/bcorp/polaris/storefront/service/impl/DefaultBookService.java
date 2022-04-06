package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.storefront.dao.BookDao;
import com.bcorp.polaris.storefront.dao.PageDao;
import com.bcorp.polaris.storefront.service.BookService;
import org.jooq.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Service(value = "bookService")
public class DefaultBookService implements BookService
{
    private BookDao bookDao;
    private PageDao pageDao;

    public DefaultBookService(BookDao bookDao, PageDao pageDao)
    {
        this.bookDao = bookDao;
        this.pageDao = pageDao;
    }

    public Record getBookForId(Long bookId)
    {
        validateParameterNotNull(bookId, "BookId must not be null");
        final Record record = bookDao.findBookWithAuthorById(bookId);
        if (record == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.RECORD_NOT_FOUND, "Book with Id: " + bookId + " not found.");
        }
        return record;
    }

    public Map<ChapterRecord, List<PageRecord>> getTableOfContent(Long bookId)
    {
        validateParameterNotNull(bookId, "BookId must not be null");
        return pageDao.findAllPageRecordsGroupByChapterByBookId(bookId);
    }
}
