package com.bcorp.polaris.storefront.facade.converter;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.core.dto.CartLineItemDto;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component(value = "dtoConverter")
public class DtoConverter
{
    public CartDto convert(Map<CartRecord, List<CartLineItemRecord>> record)
    {
        Optional<CartDto> cartDto = record.entrySet().stream().map(e -> {
            final List<CartLineItemDto> cartLineItems
                    = e.getValue().stream().map(r -> r.into(CartLineItemDto.class)).collect(Collectors.toList());

            CartDto dto = e.getKey().into(CartDto.class);
            dto.setItems(cartLineItems);
            return dto;
        }).findFirst();


        if (cartDto.isEmpty())
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, "DtoConverter convert cart error");
        }

        return cartDto.get();
    }
}
