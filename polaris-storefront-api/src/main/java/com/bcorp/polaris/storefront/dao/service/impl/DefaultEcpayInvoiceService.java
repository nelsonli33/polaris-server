package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.storefront.dao.service.InvoiceService;
import ecpay.invoice.integration.EcpayInvoiceClient;
import ecpay.invoice.integration.domain.CheckLoveCodeObj;
import ecpay.invoice.integration.domain.CheckLoveCodeResultObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "ecpayInvoiceService")
public class DefaultEcpayInvoiceService implements InvoiceService
{
    private EcpayInvoiceClient ecpayInvoiceClient;

    @Autowired
    public DefaultEcpayInvoiceService(EcpayInvoiceClient ecpayInvoiceClient)
    {
        this.ecpayInvoiceClient = ecpayInvoiceClient;
    }

    @Override
    public boolean checkLoveCode(String loveCode)
    {
        CheckLoveCodeObj obj = new CheckLoveCodeObj();
        obj.setLoveCode(loveCode);

        CheckLoveCodeResultObj resultObj = ecpayInvoiceClient.checkLoveCode(obj);

        if (resultObj == null) return false;

        if (10000010 == resultObj.getRtnCode())
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INVOICE_LOVE_CODE_ERROR,
                    "The system of the Ministry of Finance is currently under maintenance and cannot be verified. Please try again later");
        }

        return resultObj.getRtnCode() == 1 && "Y".equals(resultObj.getIsExist());
    }
}
