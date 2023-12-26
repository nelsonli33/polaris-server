package com.bcorp.polaris.storefront.controller;

import com.bcorp.polaris.core.dto.UserDto;
import com.bcorp.polaris.core.dto.UserProfileDto;
import com.bcorp.polaris.storefront.api.model.GetUserMeResponse;
import com.bcorp.polaris.storefront.api.model.GetUserProfileResponse;
import com.bcorp.polaris.storefront.api.model.UpdateUserRequest;
import com.bcorp.polaris.storefront.api.model.UpdateUserResponse;
import com.bcorp.polaris.storefront.facade.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAccountController extends AbstractController
{
    private UserFacade userFacade;

    public UserAccountController(UserFacade userFacade)
    {
        this.userFacade = userFacade;
    }

    @GetMapping(path = "/api/v1/user/me")
    public ResponseEntity<GetUserMeResponse> getUser()
    {
        final UserDto currentUser = userFacade.getCurrentUser();

        GetUserMeResponse response = GetUserMeResponse.builder()
                .user(getStorefrontRestMapper().convert2UserBasic(currentUser))
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/api/v1/user/profile")
    public ResponseEntity<GetUserProfileResponse> getUserProfile()
    {
        final UserDto currentUser = userFacade.getCurrentUser();

        GetUserProfileResponse response = GetUserProfileResponse.builder()
                .user(getStorefrontRestMapper().convert(currentUser))
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/api/v1/user/profile")
    public ResponseEntity<UpdateUserResponse> updateUserProfile(@RequestBody UpdateUserRequest body)
    {
        final UserProfileDto userProfileDto = getStorefrontRestMapper().toDto(body);
        final UserDto updatedUser = userFacade.updateUserProfile(userProfileDto);

        UpdateUserResponse response = UpdateUserResponse.builder()
                .user(getStorefrontRestMapper().convert(updatedUser))
                .build();

        return ResponseEntity.ok(response);
    }
}
