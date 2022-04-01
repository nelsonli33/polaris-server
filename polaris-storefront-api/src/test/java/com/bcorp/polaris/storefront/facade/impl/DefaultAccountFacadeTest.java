package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dto.RegisterDto;
import com.bcorp.polaris.storefront.service.AccountService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.bcorp.polaris.core.model.tables.User.USER;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class DefaultAccountFacadeTest
{
    private DefaultAccountFacade defaultAccountFacade;
    @Mock
    private AccountService accountService;
    @Mock
    private DSLContext context;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        defaultAccountFacade = new DefaultAccountFacade(accountService, context);
    }

    @Test
    void testRegister()
    {
        // given
        RegisterDto registerDto = new RegisterDto();
        registerDto.setName("dummy");
        registerDto.setEmail("dummy1234@gmail.com");
        registerDto.setPassword("dummy");

        UserRecord newUser = new UserRecord();
        given(context.newRecord(USER)).willReturn(newUser);

        // when
        defaultAccountFacade.register(registerDto);

        // then
        verify(accountService).register(newUser, registerDto.getPassword());
    }
}