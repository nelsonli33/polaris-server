package com.bcorp.polaris.storefront.facade.converter;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.core.dto.CartLineItemDto;
import com.bcorp.polaris.core.dto.OrderDto;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.core.model.tables.records.UserInvoiceSettingRecord;
import com.bcorp.polaris.core.util.EnumUtil;
import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.constant.InvoiceType;
import com.bcorp.polaris.storefront.dto.CompanyInvoiceDto;
import com.bcorp.polaris.storefront.dto.DonationInvoiceDto;
import com.bcorp.polaris.storefront.dto.PersonalInvoiceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component(value = "dtoConverter")
public class DtoConverter
{
    public CartDto convert(CartBo cartBo)
    {

        final CartRecord cartRecord = cartBo.getCart();
        final List<CartLineItemRecord> lineItems = cartBo.getLineItems();
        final List<CartLineItemDto> items
                = lineItems.stream().map(this::convert).collect(Collectors.toList());

        final CartDto dto = convert(cartRecord);
        dto.setItems(items);
        return dto;
    }

    public CartDto convert(CartRecord record)
    {
        CartDto cartDto = new CartDto();
        cartDto.setId(record.getId());
        cartDto.setUserId(record.getUserId());
        cartDto.setSubtotal(record.getSubtotal());
        cartDto.setTotalDiscounts(record.getTotalDiscounts());
        cartDto.setTotalPrice(record.getTotalPrice());
        cartDto.setCreatedAt(record.getCreatedAt());
        cartDto.setUpdatedAt(record.getUpdatedAt());
        return cartDto;
    }

    public CartLineItemDto convert(CartLineItemRecord record)
    {
        CartLineItemDto cartLineItemDto = new CartLineItemDto();
        cartLineItemDto.setId(record.getId());
        cartLineItemDto.setCartId(record.getCartId());
        cartLineItemDto.setName(record.getName());
        cartLineItemDto.setPrice(record.getPrice());
        cartLineItemDto.setCoverUrl(record.getCover());
        cartLineItemDto.setBookId(record.getBookId());
        cartLineItemDto.setSubtotal(record.getSubtotal());
        cartLineItemDto.setTotalDiscounts(record.getTotalDiscounts());
        cartLineItemDto.setTotalPrice(record.getTotalPrice());
        cartLineItemDto.setCreatedAt(record.getCreatedAt());
        cartLineItemDto.setUpdatedAt(record.getUpdatedAt());
        return cartLineItemDto;
    }

    public PersonalInvoiceDto convertToPersonalInvoiceDto(UserInvoiceSettingRecord record)
    {
        PersonalInvoiceDto personalInvoiceDto = new PersonalInvoiceDto();
        personalInvoiceDto.setInvoiceType(EnumUtil.getByCode(record.getInvoiceType().intValue(), InvoiceType.class));
        personalInvoiceDto.setEmail(record.getContactEmail());
        return personalInvoiceDto;
    }

    public CompanyInvoiceDto convertToCompanyInvoiceDto(UserInvoiceSettingRecord record)
    {
        CompanyInvoiceDto companyInvoiceDto = new CompanyInvoiceDto();
        companyInvoiceDto.setInvoiceType(EnumUtil.getByCode(record.getInvoiceType().intValue(), InvoiceType.class));
        companyInvoiceDto.setEmail(record.getContactEmail());
        companyInvoiceDto.setInvoiceTitle(record.getInvoiceTitle());
        companyInvoiceDto.setBusinessNumber(record.getBusinessNumber());
        return companyInvoiceDto;
    }

    public DonationInvoiceDto convertToDonationInvoiceDto(UserInvoiceSettingRecord record)
    {
        DonationInvoiceDto donationInvoiceDto = new DonationInvoiceDto();
        donationInvoiceDto.setInvoiceType(EnumUtil.getByCode(record.getInvoiceType().intValue(), InvoiceType.class));
        donationInvoiceDto.setCharityLovecode(record.getLovecode());
        return donationInvoiceDto;
    }

    public OrderDto convert(OrderRecord record)
    {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(record.getId());
        orderDto.setUserId(record.getUserId());
        orderDto.setInvoiceId(record.getInvoiceId());
        orderDto.setCode(record.getCode());
        orderDto.setOrderStatus(record.getOrderStatus());
        orderDto.setSubtotal(record.getSubtotal());
        orderDto.setTotalDiscounts(record.getTotalDiscounts());
        orderDto.setTotalPrice(record.getTotalPrice());
        orderDto.setPaymentMode(record.getPaymentMode());
        orderDto.setPaymentStatus(record.getPaymentStatus());
        orderDto.setPayAt(record.getPayAt());
        orderDto.setCompleteAt(record.getCompleteAt());
        orderDto.setIsDeleted(record.getIsDeleted());
        orderDto.setCreatedAt(record.getCreatedAt());
        orderDto.setUpdatedAt(record.getUpdatedAt());
        return orderDto;

    }
}
