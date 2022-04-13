package com.bcorp.polaris.storefront.dto;

import com.bcorp.polaris.core.dto.CartDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutDto
{
    private CartDto cart;
    private Double subtotal;
    private Double totalPrice;
    private String defaultPaymentMethodCode;
    private List<PaymentModeDto> paymentMethods;
//    private InvoiceSettingDTO invoiceSetting;
}
