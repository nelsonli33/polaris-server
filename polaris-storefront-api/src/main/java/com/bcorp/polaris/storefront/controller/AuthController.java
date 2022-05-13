package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.security.util.JwtTokenUtil;
import com.bcorp.polaris.storefront.api.model.LoginRequest;
import com.bcorp.polaris.storefront.api.model.RegisterUserRequest;
import com.bcorp.polaris.storefront.dto.RegisterDto;
import com.bcorp.polaris.storefront.facade.AccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class AuthController extends AbstractController
{
    private AccountFacade accountFacade;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthController(AccountFacade accountFacade, JwtTokenUtil jwtTokenUtil)
    {
        this.accountFacade = accountFacade;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping(path = "/api/v1/user/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterUserRequest body, HttpServletResponse response)
    {
        final RegisterDto registerDto = getStorefrontRestMapper().toDto(body);
        final String token = accountFacade.register(registerDto);

        Cookie cookie = new Cookie(jwtTokenUtil.getAccessTokenCookieName(), token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/api/v1/user/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest body, HttpServletResponse response)
    {
        final String token = accountFacade.login(body.getUid(), body.getPassword());

        Cookie cookie = new Cookie(jwtTokenUtil.getAccessTokenCookieName(), token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.ok().build();
    }
}
