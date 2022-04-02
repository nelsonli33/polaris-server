package com.bcorp.polaris.author.service;

import com.bcorp.polaris.core.model.tables.records.BookRecord;

public interface AuthorBookService
{
    BookRecord createNewBook(String title);
}
