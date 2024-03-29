package com.bcorp.polaris.storefront.controller.mapper;


import com.bcorp.polaris.core.dto.*;
import com.bcorp.polaris.storefront.api.model.Book;
import com.bcorp.polaris.storefront.api.model.*;
import com.bcorp.polaris.storefront.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface StorefrontRestMapper
{
    RegisterDto toDto(RegisterUserRequest body);

    UserProfileDto toDto(UpdateUserRequest body);

    Book convert(BookDto bookDto);

    List<Book> convertList(List<BookDto> bookDtos);

    User convert(UserDto userDto);

    UserBasic convert2UserBasic(UserDto userDto);

    Chapter convert(ChapterDto chapterDto);

    Page convert(PageDto pageDto);

    TableOfContent convert(TableOfContentDto tableOfContentDto);

    Cart convert(CartDto cartDto);

    CartLineItem convert(CartLineItemDto cartLineItemDto);

    Checkout convert(CheckoutDto checkoutDto);

    PaymentMode convert(PaymentModeDto paymentModeDto);

    File convert(FileDto fileDto);

    @Mapping(source = "invoiceType.code", target = "invoiceType")
    PersonalInvoice convert(PersonalInvoiceDto personalInvoiceDto);

    @Mapping(source = "invoiceType.code", target = "invoiceType")
    CompanyInvoice convert(CompanyInvoiceDto companyInvoiceDto);

    @Mapping(source = "invoiceType.code", target = "invoiceType")
    @Mapping(source = "charityLovecode", target = "loveCode")
    DonationInvoice convert(DonationInvoiceDto donationInvoiceDto);
}
