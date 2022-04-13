package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.core.model.tables.records.UserInvoiceSettingRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.constant.InvoiceType;

import java.util.List;

public interface CustomerAccountDao
{
    List<UserInvoiceSettingRecord> findInvoiceSettingForUser(UserRecord userRecord);

    UserInvoiceSettingRecord findInvoiceSettingForUserAndInvoiceType(UserRecord userRecord, InvoiceType invoiceType);
}
