package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.model.tables.records.UserRecord;

import java.util.Optional;

public interface UserDao
{
    Optional<UserRecord> findUserByUid(String uid);
}
