package com.bcorp.polaris.storefront.dto;

import com.bcorp.polaris.storefront.constant.InvoiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInvoiceDto
{
    private InvoiceType invoiceType;
    private String email;
}
