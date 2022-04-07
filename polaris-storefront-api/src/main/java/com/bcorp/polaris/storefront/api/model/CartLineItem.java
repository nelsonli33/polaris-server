package com.bcorp.polaris.storefront.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartLineItem
{
    private Long id;
    private Long bookId;
    private String name;
    private BigDecimal price;
    private String coverUrl;
    private BigDecimal subtotal;
    private BigDecimal totalDiscounts;
    private BigDecimal totalPrice;

    @JsonCreator
    public CartLineItem(
            @JsonProperty("id") Long id,
            @JsonProperty("book_id") Long bookId,
            @JsonProperty("name") String name,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("cover_url") String coverUrl,
            @JsonProperty("subtotal") BigDecimal subtotal,
            @JsonProperty("total_discounts") BigDecimal totalDiscounts,
            @JsonProperty("total_price") BigDecimal totalPrice
    )
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.coverUrl = coverUrl;
        this.bookId = bookId;
        this.subtotal = subtotal;
        this.totalDiscounts = totalDiscounts;
        this.totalPrice = totalPrice;
    }
}
