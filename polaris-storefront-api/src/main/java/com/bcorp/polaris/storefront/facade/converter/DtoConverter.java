package com.bcorp.polaris.storefront.facade.converter;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.core.dto.CartLineItemDto;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.bo.CartBo;
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

}
