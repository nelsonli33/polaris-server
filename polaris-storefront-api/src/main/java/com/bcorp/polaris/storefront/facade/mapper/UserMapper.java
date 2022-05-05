package com.bcorp.polaris.storefront.facade.mapper;

import com.bcorp.polaris.core.dto.UserDto;
import com.bcorp.polaris.core.dto.UserProfileDto;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = FacadeMapperConfig.class)
public interface UserMapper
{
    @Mapping(target = "websiteUrl", source = "website")
    @Mapping(target = "facebookUrl", source = "facebook")
    @Mapping(target = "linkedInUrl", source = "linkedin")
    @Mapping(target = "youtubeUrl", source = "youtube")
    UserDto toDto(UserRecord userRecord);

    @Mapping(target = "website", source = "websiteUrl")
    @Mapping(target = "facebook", source = "facebookUrl")
    @Mapping(target = "linkedin", source = "linkedInUrl")
    @Mapping(target = "youtube", source = "youtubeUrl")
    void updateUserProfile(UserProfileDto userProfileDto, @MappingTarget UserRecord userRecord);
}
