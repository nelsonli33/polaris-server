package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.storefront.bo.BookBo;

public interface BookBoFactory
{
    BookBo createBookBo(BookRecord bookRecord);
}
