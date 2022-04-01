package com.bcorp.polaris.storefront.mapstruct.mapper;

import com.bcorp.polaris.storefront.dto.RegisterDto;
import com.bcorp.polaris.storefront.model.RegisterUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface AuthRestMapper
{
    RegisterDto toDto(RegisterUserRequest body);
}
