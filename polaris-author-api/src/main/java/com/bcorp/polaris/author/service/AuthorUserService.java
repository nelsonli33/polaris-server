package com.bcorp.polaris.author.service;

import com.bcorp.polaris.core.model.tables.records.UserRecord;

public interface AuthorUserService
{
    UserRecord getCurrentAuthorUser();
}
