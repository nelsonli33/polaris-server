package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.model.tables.records.UserRecord;

public interface AccountService
{
    void register(UserRecord newUser, String password);

    String login(String uid, String password);
}
