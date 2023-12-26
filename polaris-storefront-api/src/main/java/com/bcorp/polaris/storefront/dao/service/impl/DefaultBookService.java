package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.dao.BookDao;
import com.bcorp.polaris.storefront.dao.PageDao;
import com.bcorp.polaris.storefront.dao.service.BookBoFactory;
import com.bcorp.polaris.storefront.dao.service.BookService;
import org.jooq.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Service(value = "bookService")
public class DefaultBookService implements BookService
{
    private BookDao bookDao;
    private PageDao pageDao;
    private BookBoFactory bookBoFactory;

    public DefaultBookService(BookDao bookDao, PageDao pageDao, BookBoFactory bookBoFactory)
    {
        this.bookDao = bookDao;
        this.pageDao = pageDao;
        this.bookBoFactory = bookBoFactory;
    }

    @Override
    public List<BookRecord> getAllBooks()
    {
        return bookDao.findAllBooks();
    }

    public BookRecord getBookForId(Long bookId)
    {
        validateParameterNotNull(bookId, "BookId must not be null");
        final BookRecord bookRecord = bookDao.findBookById(bookId);
        if (bookRecord == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.RECORD_NOT_FOUND, "Book with Id: " + bookId + " not found.");
        }
        return bookRecord;
    }

    public BookBo getBookAndAuthorForId(Long bookId)
    {
        validateParameterNotNull(bookId, "BookId must not be null");
        final Record record = bookDao.findBookWithAuthorById(bookId);
        if (record == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.RECORD_NOT_FOUND, "Book with Id: " + bookId + " not found.");
        }

        return BookBo.builder()
                .book(record.into(BookRecord.class))
                .author(record.into(UserRecord.class))
                .build();
    }

    public Map<ChapterRecord, List<PageRecord>> getTableOfContent(Long bookId)
    {
        validateParameterNotNull(bookId, "BookId must not be null");
        return pageDao.findAllPageRecordsGroupByChapterByBookId(bookId);
    }


    public BookBo getBookBo(BookRecord bookRecord)
    {
        validateParameterNotNullStandardMessage("bookRecord", bookRecord);
        return bookBoFactory.createBookBo(bookRecord);
    }

}
