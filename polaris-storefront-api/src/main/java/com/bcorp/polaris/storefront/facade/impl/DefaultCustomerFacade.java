package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.model.tables.records.UserInvoiceSettingRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.core.util.EnumUtil;
import com.bcorp.polaris.storefront.constant.InvoiceType;
import com.bcorp.polaris.storefront.dao.service.CustomerAccountService;
import com.bcorp.polaris.storefront.dao.service.UserService;
import com.bcorp.polaris.storefront.dto.CompanyInvoiceDto;
import com.bcorp.polaris.storefront.dto.DonationInvoiceDto;
import com.bcorp.polaris.storefront.dto.InvoiceSettingDto;
import com.bcorp.polaris.storefront.dto.PersonalInvoiceDto;
import com.bcorp.polaris.storefront.facade.CustomerFacade;
import com.bcorp.polaris.storefront.facade.converter.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "customerFacade")
public class DefaultCustomerFacade implements CustomerFacade
{
    private CustomerAccountService customerAccountService;
    private UserService userService;
    private DtoConverter dtoConverter;

    @Autowired
    public DefaultCustomerFacade(
            CustomerAccountService customerAccountService,
            UserService userService,
            DtoConverter dtoConverter
    )
    {
        this.customerAccountService = customerAccountService;
        this.userService = userService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public InvoiceSettingDto getCustomerInvoiceSetting()
    {
        final UserRecord currentUser = userService.getCurrentUser();
        final List<UserInvoiceSettingRecord> records
                = customerAccountService.getInvoiceSettingForUser(currentUser);

        InvoiceSettingDto invoiceSettingDto = new InvoiceSettingDto();

        for (UserInvoiceSettingRecord record : records)
        {
            switch (EnumUtil.getByCode(record.getInvoiceType().intValue(), InvoiceType.class))
            {
                case PERSON:
                    invoiceSettingDto.setPersonal(dtoConverter.convertToPersonalInvoiceDto(record));
                    break;
                case COMPANY:
                    invoiceSettingDto.setCompany(dtoConverter.convertToCompanyInvoiceDto(record));
                    break;
                case DONATION:
                    invoiceSettingDto.setDonation(dtoConverter.convertToDonationInvoiceDto(record));
                    break;
            }
        }
        return invoiceSettingDto;
    }

    @Override
    public PersonalInvoiceDto savePersonalInvoiceSetting(PersonalInvoiceDto personalInvoiceDto)
    {
        final UserRecord currentUser = userService.getCurrentUser();
        final UserInvoiceSettingRecord personalInvoiceRecord
                = customerAccountService.savePersonalInvoiceSetting(currentUser, personalInvoiceDto);
        return dtoConverter.convertToPersonalInvoiceDto(personalInvoiceRecord);
    }

    @Override
    public CompanyInvoiceDto saveCompanyInvoiceSetting(CompanyInvoiceDto companyInvoiceDto)
    {
        final UserRecord currentUser = userService.getCurrentUser();
        final UserInvoiceSettingRecord companyInvoiceRecord
                = customerAccountService.saveCustomerInvoiceSetting(currentUser, companyInvoiceDto);
        return dtoConverter.convertToCompanyInvoiceDto(companyInvoiceRecord);
    }

    @Override
    public DonationInvoiceDto saveDonationInvoiceSetting(DonationInvoiceDto donationInvoiceDto)
    {
        final UserRecord currentUser = userService.getCurrentUser();
        final UserInvoiceSettingRecord donationInvoiceRecord
                = customerAccountService.saveDonationInvoiceSetting(currentUser, donationInvoiceDto);
        return dtoConverter.convertToDonationInvoiceDto(donationInvoiceRecord);
    }
}
