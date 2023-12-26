package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.storefront.dao.service.EcpayPaymentService;
import ecpay.payment.integration.EcpayPaymentClient;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service(value = "ecpayPaymentService")
public class DefaultEcpayPaymentService implements EcpayPaymentService
{
    private EcpayPaymentClient ecpayPaymentClient;

    @Autowired
    public DefaultEcpayPaymentService(EcpayPaymentClient ecpayPaymentClient)
    {
        this.ecpayPaymentClient = ecpayPaymentClient;
    }

    public String genCreditOnceCheckoutForm(String orderCode,
                                            String totalPrice,
                                            String itemName,
                                            String tradeDesc,
                                            String returnUrl,
                                            String orderResultUrl,
                                            String clientBackUrl)
    {
        AioCheckOutOneTime obj = new AioCheckOutOneTime();
        obj.setMerchantTradeNo(orderCode);
        obj.setMerchantTradeDate(formatDate(new Date()));
        obj.setTotalAmount(totalPrice);
        obj.setTradeDesc(tradeDesc);
        obj.setItemName(itemName); // 符號#分隔
        obj.setReturnURL(returnUrl);
        obj.setClientBackURL(clientBackUrl);
        obj.setNeedExtraPaidInfo("N");
        obj.setRedeem("Y");
        return ecpayPaymentClient.aioCheckOut(obj, null);
    }

    protected String formatDate(final Date date)
    {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formatter.format(date);
    }
}
