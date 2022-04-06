package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.storefront.api.model.LoginRequest;
import com.bcorp.polaris.storefront.api.model.LoginResponse;
import com.bcorp.polaris.storefront.api.model.RegisterUserRequest;
import com.bcorp.polaris.storefront.controller.mapper.StorefrontRestMapper;
import com.bcorp.polaris.storefront.dto.RegisterDto;
import com.bcorp.polaris.storefront.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController
{
    private StorefrontRestMapper storefrontRestMapper;
    private AccountFacade accountFacade;

    @Autowired
    public AuthController(StorefrontRestMapper storefrontRestMapper, AccountFacade accountFacade)
    {
        this.storefrontRestMapper = storefrontRestMapper;
        this.accountFacade = accountFacade;
    }

    @PostMapping(path = "/api/v1/user/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterUserRequest body)
    {
        final RegisterDto registerDto = storefrontRestMapper.toDto(body);
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
