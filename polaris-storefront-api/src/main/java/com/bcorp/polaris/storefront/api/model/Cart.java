package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class Cart
{
    private Long userId;
    private BigDecimal subtotal;
    private BigDecimal totalDiscounts;
    private BigDecimal totalPrice;
    private List<CartLineItem> items;

    public Cart(
            @JsonProperty("user_id") Long userId,
            @JsonProperty("subtotal") BigDecimal subtotal,
            @JsonProperty("total_discounts") BigDecimal totalDiscounts,
            @JsonProperty("total_price") BigDecimal totalPrice,
            @JsonProperty("items") List<CartLineItem> items
    )
    {
        this.userId = userId;
        this.subtotal = subtotal;
        this.totalDiscounts = totalDiscounts;
        this.totalPrice = totalPrice;
        this.items = items;
    }
}
