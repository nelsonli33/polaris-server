package com.bcorp.polaris.storefront.dao.impl;

import com.bcorp.polaris.core.model.tables.records.UserInvoiceSettingRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.constant.InvoiceType;
import com.bcorp.polaris.storefront.dao.CustomerAccountDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.bcorp.polaris.core.model.tables.UserInvoiceSetting.USER_INVOICE_SETTING;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Repository
public class DefaultCustomerAccountDao implements CustomerAccountDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultCustomerAccountDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }


    @Override
    public List<UserInvoiceSettingRecord> findInvoiceSettingForUser(UserRecord userRecord)
    {
        validateParameterNotNullStandardMessage("userRecord", userRecord);

        return dslContext.select().from(USER_INVOICE_SETTING).where(USER_INVOICE_SETTING.USER_ID.eq(userRecord.getId()))
                .fetchInto(UserInvoiceSettingRecord.class);
    }

    @Override
    public UserInvoiceSettingRecord findInvoiceSettingForUserAndInvoiceType(UserRecord userRecord, InvoiceType invoiceType)
    {
        validateParameterNotNullStandardMessage("userRecord", userRecord);
        validateParameterNotNullStandardMessage("invoiceType", invoiceType);

        return dslContext.fetchOne(USER_INVOICE_SETTING, USER_INVOICE_SETTING.USER_ID.eq(userRecord.getId())
                .and(USER_INVOICE_SETTING.INVOICE_TYPE.eq(invoiceType.getCode().byteValue())));
    }
}
