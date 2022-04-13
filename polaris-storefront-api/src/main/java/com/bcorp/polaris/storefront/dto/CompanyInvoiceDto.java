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
public class CompanyInvoiceDto
{
    private InvoiceType invoiceType;
    private String email;
    private String invoiceTitle; // 發票抬頭
    private String businessNumber; // 統一編號
}
