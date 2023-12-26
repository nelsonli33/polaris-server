package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.security.util.JwtTokenUtil;
import com.bcorp.polaris.storefront.dao.AccountDao;
import com.bcorp.polaris.storefront.dao.service.AccountService;
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
    public String register(UserRecord newUser, String password)
    {
        final boolean isAccountExists = accountDao.checkAccountIsExistsByUid(newUser.getUid());
        if (isAccountExists)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.USER_ACCOUNT_EXISTS, "此使用者已註冊");
        }
        final String encodedPassword = passwordEncoder.encode(password);
        newUser.setPassword(encodedPassword);
        dslContext.executeInsert(newUser);

        return login(newUser.getUid(), password);
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
            throw new PolarisServerRuntimeException(InternalErrorCode.USER_LOGIN_FAILED, "你的帳號或密碼不正確，請再試一次");
        }
    }

}
