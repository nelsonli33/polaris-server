package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.core.dto.UserDto;
import com.bcorp.polaris.core.dto.UserProfileDto;

public interface UserFacade
{
    UserDto getCurrentUser();

    UserDto updateUserProfile(UserProfileDto userDto);
}
