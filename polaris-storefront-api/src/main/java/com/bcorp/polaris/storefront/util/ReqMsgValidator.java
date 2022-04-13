package com.bcorp.polaris.storefront.util;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.util.EnumUtil;
import com.bcorp.polaris.storefront.api.model.CheckoutInvoice;
import com.bcorp.polaris.storefront.api.model.SaveInvoiceSettingRequest;
import com.bcorp.polaris.storefront.constant.InvoiceType;
import org.apache.commons.lang3.StringUtils;

public class ReqMsgValidator
{
    public static class CustomerAccount
    {
        public static void validatePersonalInvoiceSetting(SaveInvoiceSettingRequest body)
        {
            if (body == null)
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "SaveInvoiceSettingRequest should not be null");
            }

            if (StringUtils.isEmpty(body.getEmail()))
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "E-mail can not be empty.");
            }
        }

        public static void validateCompanyInvoiceSetting(SaveInvoiceSettingRequest body)
        {
            if (body == null)
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "SaveInvoiceSettingRequest should not be null");
            }

            if (StringUtils.isEmpty(body.getEmail()))
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "E-mail can not be empty.");
            }

            if (StringUtils.isEmpty(body.getInvoiceTitle()))
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "Invoice title can not be empty.");
            }

            if (StringUtils.isEmpty(body.getBusinessNumber()))
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "Business number can not be empty.");
            }
        }

        public static void validateDonationInvoiceSetting(SaveInvoiceSettingRequest body)
        {
            if (body == null)
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "SaveInvoiceSettingRequest should not be null");
            }

            if (StringUtils.isEmpty(body.getLoveCode()))
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "Love code can not be empty.");
            }
        }
    }

    public static class Checkout
    {
        public static void validateCheckoutInvoice(CheckoutInvoice checkoutInvoice)
        {
            final InvoiceType invoiceType = EnumUtil.getByCode(checkoutInvoice.getInvoiceType(), InvoiceType.class);
            if (invoiceType == null)
            {
                throw new PolarisServerRuntimeException(InternalErrorCode.ENUM_CODE_NOT_FOUND, "InvoiceType: " + checkoutInvoice.getInvoiceType() + " for invoice setting");
            }

            switch (invoiceType)
            {
                case PERSON:
                    if (StringUtils.isEmpty(checkoutInvoice.getEmail()))
                    {
                        throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "E-mail can not be empty.");
                    }
                    break;

                case COMPANY:
                    if (StringUtils.isEmpty(checkoutInvoice.getEmail()))
                    {
                        throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "E-mail can not be empty.");
                    }

                    if (StringUtils.isEmpty(checkoutInvoice.getInvoiceTitle()))
                    {
                        throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "Invoice title can not be empty.");
                    }

                    if (StringUtils.isEmpty(checkoutInvoice.getBusinessNumber()))
                    {
                        throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "Business number can not be empty.");
                    }
                    break;

                case DONATION:
                    if (StringUtils.isEmpty(checkoutInvoice.getLoveCode()))
                    {
                        throw new PolarisServerRuntimeException(InternalErrorCode.INVALID_REQUEST_BODY, "Love code can not be empty.");
                    }
                    break;
            }
        }
    }
}
