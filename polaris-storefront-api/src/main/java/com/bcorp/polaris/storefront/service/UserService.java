package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.UserRecord;

public interface UserService
{
    UserRecord getCartForCurrentUser();
}
