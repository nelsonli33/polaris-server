package com.bcorp.polaris.core.dao;

import com.bcorp.polaris.core.model.tables.records.UserRecord;

import java.util.Optional;

public interface UserDao
{
    Optional<UserRecord> findUserByUid(String uid);
}
