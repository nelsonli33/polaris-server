package com.bcorp.polaris.author.dao.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DefaultAuthorBookDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultAuthorBookDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public void findBookIntroById()
    {


    }
}
