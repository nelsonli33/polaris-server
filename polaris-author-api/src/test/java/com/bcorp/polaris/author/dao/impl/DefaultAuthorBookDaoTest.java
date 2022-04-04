package com.bcorp.polaris.author.dao.impl;

import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;

@JooqTest
class DefaultAuthorBookDaoTest
{
    private DefaultAuthorBookDao defaultAuthorBookDao;
    @Autowired
    private DSLContext dslContext;

    @BeforeEach
    void setUp()
    {
        defaultAuthorBookDao = new DefaultAuthorBookDao(dslContext);
    }

    @Test
    void testFindBookIntro()
    {
        defaultAuthorBookDao.findBookIntroById();
    }
}