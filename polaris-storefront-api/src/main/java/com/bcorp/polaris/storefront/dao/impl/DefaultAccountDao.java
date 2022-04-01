package com.bcorp.polaris.storefront.dao.impl;

import com.bcorp.polaris.storefront.dao.AccountDao;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.bcorp.polaris.model.Tables.USER;

@Repository
public class DefaultAccountDao implements AccountDao
{
    private DSLContext dslContext;

    public DefaultAccountDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public boolean checkAccountIsExistsByUid(String uid)
    {
        return dslContext.fetchExists(dslContext.selectOne()
                .from(USER).where(USER.UID.eq(uid.toLowerCase())));
    }
}
