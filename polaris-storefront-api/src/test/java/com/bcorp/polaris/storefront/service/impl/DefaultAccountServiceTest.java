package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.security.util.JwtTokenUtil;
import com.bcorp.polaris.storefront.dao.AccountDao;
import com.bcorp.polaris.storefront.dao.service.impl.DefaultAccountService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class DefaultAccountServiceTest
{
    private DefaultAccountService defaultAccountService;
    @Mock
    private AccountDao accountDao;
    @Mock
    private DSLContext dslContext;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private UserRecord user;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtTokenUtil jwtTokenUtil;


    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        defaultAccountService = new DefaultAccountService(accountDao, dslContext, passwordEncoder, authenticationManager, jwtTokenUtil);
        given(user.getName()).willReturn("testName");
        given(user.getUid()).willReturn("testUid");
    }

    @Test
    void testRegister()
    {
        // given
        given(accountDao.checkAccountIsExistsByUid(anyString())).willReturn(false);
        // when
        defaultAccountService.register(user, "dummy");
        // then
        verify(passwordEncoder).encode("dummy");
        verify(dslContext).executeInsert(user);
    }

    @Test
    void testRegisterErr_AccountExists()
    {
        // given
        given(accountDao.checkAccountIsExistsByUid(anyString())).willReturn(true);
        // when
        // then
        assertThrows(PolarisServerRuntimeException.class, () -> defaultAccountService.register(user, "dummy"), "此使用者已註冊");
    }

}