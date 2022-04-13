package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.UserInvoiceSettingRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.constant.InvoiceType;
import com.bcorp.polaris.storefront.dao.CustomerAccountDao;
import com.bcorp.polaris.storefront.dto.CompanyInvoiceDto;
import com.bcorp.polaris.storefront.dto.DonationInvoiceDto;
import com.bcorp.polaris.storefront.dto.PersonalInvoiceDto;
import com.bcorp.polaris.storefront.service.CustomerAccountService;
import com.bcorp.polaris.storefront.service.InvoiceService;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bcorp.polaris.core.model.Tables.USER_INVOICE_SETTING;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Service(value = "customerAccountService")
public class DefaultCustomerAccountService implements CustomerAccountService
{
    private DSLContext dslContext;
    private CustomerAccountDao customerAccountDao;
    private InvoiceService ecpayInvoiceService;

    public DefaultCustomerAccountService(DSLContext dslContext, CustomerAccountDao customerAccountDao, InvoiceService ecpayInvoiceService)
    {
        this.dslContext = dslContext;
        this.customerAccountDao = customerAccountDao;
        this.ecpayInvoiceService = ecpayInvoiceService;
    }

    @Override
    public List<UserInvoiceSettingRecord> getInvoiceSettingForUser(UserRecord currentUser)
    {
        validateParameterNotNullStandardMessage("currentUser", currentUser);
        return customerAccountDao.findInvoiceSettingForUser(currentUser);
    }

    @Override
    public UserInvoiceSettingRecord savePersonalInvoiceSetting(UserRecord currentUser, PersonalInvoiceDto personalInvoiceDto)
    {
        validateParameterNotNullStandardMessage("personalInvoiceDto", personalInvoiceDto);
        final UserInvoiceSettingRecord record
                = customerAccountDao.findInvoiceSettingForUserAndInvoiceType(currentUser, InvoiceType.PERSON);

        if (record != null)
        {
            record.setContactEmail(personalInvoiceDto.getEmail());
            record.update();
            return record;
        }
        else
        {
            UserInvoiceSettingRecord newRecord = dslContext.newRecord(USER_INVOICE_SETTING);
            newRecord.setInvoiceType(InvoiceType.PERSON.getCode().byteValue());
            newRecord.setUserId(currentUser.getId());
            newRecord.setContactEmail(personalInvoiceDto.getEmail());
            newRecord.store();
            return newRecord;
        }
    }

    public UserInvoiceSettingRecord saveCustomerInvoiceSetting(UserRecord currentUser, CompanyInvoiceDto companyInvoiceDto)
    {
        validateParameterNotNullStandardMessage("companyInvoiceDto", companyInvoiceDto);
        final UserInvoiceSettingRecord record
                = customerAccountDao.findInvoiceSettingForUserAndInvoiceType(currentUser, InvoiceType.COMPANY);

        if (record != null)
        {
            record.setInvoiceTitle(companyInvoiceDto.getInvoiceTitle());
            record.setBusinessNumber(companyInvoiceDto.getBusinessNumber());
            record.setContactEmail(companyInvoiceDto.getEmail());
            record.update();
            return record;
        }
        else
        {
            UserInvoiceSettingRecord newRecord = dslContext.newRecord(USER_INVOICE_SETTING);
            newRecord.setInvoiceType(InvoiceType.COMPANY.getCode().byteValue());
            newRecord.setUserId(currentUser.getId());
            newRecord.setInvoiceTitle(companyInvoiceDto.getInvoiceTitle());
            newRecord.setBusinessNumber(companyInvoiceDto.getBusinessNumber());
            newRecord.setContactEmail(companyInvoiceDto.getEmail());
            newRecord.store();
            return newRecord;
        }
    }

    public UserInvoiceSettingRecord saveDonationInvoiceSetting(UserRecord currentUser, DonationInvoiceDto donationInvoiceDto)
    {
        validateParameterNotNullStandardMessage("donationInvoiceDto", donationInvoiceDto);
        final UserInvoiceSettingRecord record
                = customerAccountDao.findInvoiceSettingForUserAndInvoiceType(currentUser, InvoiceType.DONATION);

        boolean isValidLoveCode = ecpayInvoiceService.checkLoveCode(donationInvoiceDto.getCharityLovecode());
        if (!isValidLoveCode)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INVOICE_LOVE_CODE_NOT_EXIST, "Love code not exist.");
        }

        if (record != null)
        {
            record.setLovecode(donationInvoiceDto.getCharityLovecode());
            record.update();
            return record;
        }
        else
        {
            UserInvoiceSettingRecord newRecord = dslContext.newRecord(USER_INVOICE_SETTING);
            newRecord.setInvoiceType(InvoiceType.DONATION.getCode().byteValue());
            newRecord.setUserId(currentUser.getId());
            newRecord.setLovecode(donationInvoiceDto.getCharityLovecode());
            newRecord.store();
            return newRecord;
        }
    }

}
