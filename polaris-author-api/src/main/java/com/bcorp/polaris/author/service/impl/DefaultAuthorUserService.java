package com.bcorp.polaris.author.service.impl;

import com.bcorp.polaris.author.service.AuthorUserService;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisAuthenticationException;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.core.type.UserRole;
import com.bcorp.polaris.security.service.CoreUserDetails;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service(value = "authorUserService")
public class DefaultAuthorUserService implements AuthorUserService
{
    public UserRecord getCurrentAuthorUser()
    {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || StringUtils.isEmpty(authentication.getName()) || authentication.getPrincipal() == null)
        {
            throw new PolarisAuthenticationException();
        }

        final CoreUserDetails coreUserDetails = (CoreUserDetails) authentication.getPrincipal();
        final UserRecord userRecord = coreUserDetails.getUserRecord();

        if (userRecord.getIsAuthor().intValue() == UserRole.AUTHOR.getValue())
        {
            return userRecord;
        }
        else
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, "The user has no author role.");
        }
    }
}
