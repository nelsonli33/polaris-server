package com.bcorp.polaris.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartLineItemDto
{
    private Long id;
    private Long cartId;
    private String name;
    private BigDecimal price;
    private String coverUrl;
    private Long bookId;
    private BigDecimal subtotal;
    private BigDecimal totalDiscounts;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
