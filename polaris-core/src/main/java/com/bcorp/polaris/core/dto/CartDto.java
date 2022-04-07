package com.bcorp.polaris.core.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDto
{
    private Long id;
    private Long userId;
    private BigDecimal subtotal;
    private BigDecimal totalDiscounts;
    private BigDecimal totalPrice;
    private List<CartLineItemDto> items;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
