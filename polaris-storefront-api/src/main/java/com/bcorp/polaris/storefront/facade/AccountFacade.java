package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.storefront.dto.RegisterDto;

public interface AccountFacade
{
    String register(RegisterDto registerDto);

    String login(String uid, String password);
}
