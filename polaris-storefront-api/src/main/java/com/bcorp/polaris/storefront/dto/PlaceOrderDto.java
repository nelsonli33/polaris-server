package com.bcorp.polaris.storefront.dto;

import com.bcorp.polaris.storefront.constant.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderDto
{
    private PaymentType paymentType;
    private InvoiceDto invoiceDto;
}
