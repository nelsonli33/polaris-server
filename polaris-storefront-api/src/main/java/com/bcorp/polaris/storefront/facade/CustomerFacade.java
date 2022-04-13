package com.bcorp.polaris.storefront.facade;

import com.bcorp.polaris.storefront.dto.CompanyInvoiceDto;
import com.bcorp.polaris.storefront.dto.DonationInvoiceDto;
import com.bcorp.polaris.storefront.dto.InvoiceSettingDto;
import com.bcorp.polaris.storefront.dto.PersonalInvoiceDto;

public interface CustomerFacade
{
    InvoiceSettingDto getCustomerInvoiceSetting();

    PersonalInvoiceDto savePersonalInvoiceSetting(PersonalInvoiceDto personalInvoiceDto);

    CompanyInvoiceDto saveCompanyInvoiceSetting(CompanyInvoiceDto companyInvoiceDTO);

    DonationInvoiceDto saveDonationInvoiceSetting(DonationInvoiceDto donationInvoiceDTO);
}
