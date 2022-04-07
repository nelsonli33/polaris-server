package com.bcorp.polaris.storefront.controller.mapper;


import com.bcorp.polaris.core.dto.*;
import com.bcorp.polaris.storefront.api.model.Book;
import com.bcorp.polaris.storefront.api.model.*;
import com.bcorp.polaris.storefront.dto.RegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface StorefrontRestMapper
{
    RegisterDto toDto(RegisterUserRequest body);

    Book convert(BookDto bookDto);

    User convert(UserDto userDto);

    Chapter convert(ChapterDto chapterDto);

    Page convert(PageDto pageDto);

    TableOfContent convert(TableOfContentDto tableOfContentDto);

    Cart convert(CartDto cartDto);

    CartLineItem convert(CartLineItemDto cartLineItemDto);
}
