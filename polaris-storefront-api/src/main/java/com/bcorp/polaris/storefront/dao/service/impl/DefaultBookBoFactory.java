package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.dao.service.BookBoFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Component(value = "bookBoFactory")
public class DefaultBookBoFactory implements BookBoFactory
{
    @Override
    public BookBo createBookBo(BookRecord bookRecord)
    {
        validateParameterNotNullStandardMessage("bookRecord", bookRecord);

        BookBo bookBo = new BookBo();
        bookBo.setTitle(bookRecord.getTitle());
        bookBo.setPrice(bookRecord.getPrice());
        bookBo.setBookId(bookRecord.getId());
        bookBo.setBook(bookRecord);
        bookBo.setKey(generateKey(bookRecord.getId(), bookRecord.getTitle(), bookRecord.getPrice()));
        return bookBo;
    }

    private String generateKey(Long bookId, String title, BigDecimal price)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(bookId).append(":");

        StringBuilder propertyBuilder = new StringBuilder();
        propertyBuilder.append(title);
        propertyBuilder.append(price);
        String key = DigestUtils.md5DigestAsHex(propertyBuilder.toString().getBytes(StandardCharsets.UTF_8));

        builder.append(key);
        return builder.toString();
    }
}
