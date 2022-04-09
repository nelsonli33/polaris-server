package com.bcorp.polaris.storefront.dto.error;


import com.bcorp.polaris.storefront.constant.CartLineItemInvalidType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartLineItemError
{
    private Long lineItemId;
    private Long bookId;
    private CartLineItemInvalidType invalidType;
    private String errorMessage;
}
