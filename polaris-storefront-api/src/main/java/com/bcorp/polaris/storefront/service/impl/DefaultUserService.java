package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.core.exception.PolarisAuthenticationException;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.security.service.CoreUserDetails;
import com.bcorp.polaris.storefront.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class DefaultUserService implements UserService
{
    @Override
    public UserRecord getCurrentUser()
    {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || StringUtils.isEmpty(authentication.getName()) || authentication.getPrincipal() == null)
        {
            throw new PolarisAuthenticationException();
        }

        final CoreUserDetails coreUserDetails = (CoreUserDetails) authentication.getPrincipal();
        return coreUserDetails.getUserRecord();
    }
}
