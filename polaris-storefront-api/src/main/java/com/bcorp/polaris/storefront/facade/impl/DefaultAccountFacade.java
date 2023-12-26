package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dao.service.AccountService;
import com.bcorp.polaris.storefront.dto.RegisterDto;
import com.bcorp.polaris.storefront.facade.AccountFacade;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bcorp.polaris.core.model.tables.User.USER;

@Component
public class DefaultAccountFacade implements AccountFacade
{
    private AccountService accountService;
    private DSLContext dslContext;

    @Autowired
    public DefaultAccountFacade(AccountService accountService, DSLContext dslContext)
    {
        this.accountService = accountService;
        this.dslContext = dslContext;
    }

    @Override
    public String register(RegisterDto registerDto)
    {
        UserRecord newUser = dslContext.newRecord(USER);
        newUser.setName(registerDto.getName());
        newUser.setEmail(registerDto.getEmail());
        newUser.setUid(registerDto.getEmail().toLowerCase());

        return accountService.register(newUser, registerDto.getPassword());
    }

    @Override
    public String login(String uid, String password)
    {
        return accountService.login(uid, password);
    }
}
