package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.UserDto;
import com.bcorp.polaris.core.dto.UserProfileDto;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.facade.UserFacade;
import com.bcorp.polaris.storefront.facade.mapper.UserMapper;
import com.bcorp.polaris.storefront.service.UserService;
import org.springframework.stereotype.Component;

@Component(value = "userFacade")
public class DefaultUserFacade implements UserFacade
{
    private UserService userService;
    private UserMapper userMapper;

    public DefaultUserFacade(UserService userService, UserMapper userMapper)
    {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto getCurrentUser()
    {
        final UserRecord currentUser = userService.getCurrentUser();
        return userMapper.toDto(currentUser);
    }

    public UserDto updateUserProfile(UserProfileDto userProfileDto)
    {
        final UserRecord currentUser = userService.getCurrentUser();
        userMapper.updateUserProfile(userProfileDto, currentUser);
        currentUser.update();
        return userMapper.toDto(currentUser);
    }
}
