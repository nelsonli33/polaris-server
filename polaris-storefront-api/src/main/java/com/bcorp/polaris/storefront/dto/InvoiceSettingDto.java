package com.bcorp.polaris.storefront.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceSettingDto
{
    private PersonalInvoiceDto personal;
    private CompanyInvoiceDto company;
    private DonationInvoiceDto donation;
}
