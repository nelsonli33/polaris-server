package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.storefront.dto.RegisterDto;
import com.bcorp.polaris.storefront.facade.AccountFacade;
import com.bcorp.polaris.storefront.mapstruct.mapper.AuthRestMapper;
import com.bcorp.polaris.storefront.model.LoginRequest;
import com.bcorp.polaris.storefront.model.LoginResponse;
import com.bcorp.polaris.storefront.model.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController
{
    private AuthRestMapper authRestMapper;
    private AccountFacade accountFacade;

    @Autowired
    public AuthController(AuthRestMapper authRestMapper, AccountFacade accountFacade)
    {
        this.authRestMapper = authRestMapper;
        this.accountFacade = accountFacade;
    }

    @PostMapping(path = "/api/v1/user/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterUserRequest body)
    {
        final RegisterDto registerDto = authRestMapper.toDto(body);
        accountFacade.register(registerDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/api/v1/user/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest body)
    {
        final String token = accountFacade.login(body.getUid(), body.getPassword());
        return LoginResponse
                .builder()
                .accessToken(token)
                .build();
    }
}
