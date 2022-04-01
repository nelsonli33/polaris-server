package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dao.AccountDao;
import com.bcorp.polaris.storefront.error.InternalErrorCode;
import com.bcorp.polaris.storefront.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.storefront.service.AccountService;
import com.bcorp.polaris.storefront.util.JwtTokenUtil;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultAccountService implements AccountService
{
    private AccountDao accountDao;
    private DSLContext dslContext;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    public DefaultAccountService(AccountDao accountDao,
                                 DSLContext dslContext,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 JwtTokenUtil jwtTokenUtil)
    {
        this.accountDao = accountDao;
        this.dslContext = dslContext;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public void register(UserRecord newUser, String password)
    {
        final boolean isAccountExists = accountDao.checkAccountIsExistsByUid(newUser.getUid());
        if (isAccountExists)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.USER_ACCOUNT_EXISTS, "此使用者已註冊");
        }
        final String encodedPassword = passwordEncoder.encode(password);
        newUser.setPassword(encodedPassword);
        dslContext.executeInsert(newUser);
    }

    @Override
    public String login(String uid, String password)
    {
        try
        {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(uid, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return jwtTokenUtil.generateToken(authentication);
        }
        catch (AuthenticationException ex)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.USER_LOGIN_FAILED, ex);
        }
    }

}
