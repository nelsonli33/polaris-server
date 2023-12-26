package com.bcorp.polaris.storefront.dao.service;

import com.bcorp.polaris.core.model.tables.records.UserInvoiceSettingRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dto.CompanyInvoiceDto;
import com.bcorp.polaris.storefront.dto.DonationInvoiceDto;
import com.bcorp.polaris.storefront.dto.PersonalInvoiceDto;

import java.util.List;

public interface CustomerAccountService
{
    List<UserInvoiceSettingRecord> getInvoiceSettingForUser(UserRecord currentUser);

    UserInvoiceSettingRecord savePersonalInvoiceSetting(UserRecord currentUser, PersonalInvoiceDto personalInvoiceDto);

    UserInvoiceSettingRecord saveCustomerInvoiceSetting(UserRecord currentUser, CompanyInvoiceDto companyInvoiceDto);

    UserInvoiceSettingRecord saveDonationInvoiceSetting(UserRecord currentUser, DonationInvoiceDto donationInvoiceDto);
}
