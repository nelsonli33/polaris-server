package com.bcorp.polaris.core.dao.impl;

import com.bcorp.polaris.core.dao.UserDao;
import com.bcorp.polaris.core.model.tables.User;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultUserDao implements UserDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultUserDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public Optional<UserRecord> findUserByUid(String uid)
    {
        UserRecord u = dslContext.fetchOne(User.USER, User.USER.UID.eq(uid.toLowerCase()));
        return Optional.ofNullable(u);
    }

}
