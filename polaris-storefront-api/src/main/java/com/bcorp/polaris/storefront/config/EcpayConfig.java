package com.bcorp.polaris.storefront.config;

import ecpay.invoice.integration.EcpayInvoiceClient;
import ecpay.payment.integration.EcpayPaymentClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EcpayConfig
{
    @Bean(name = "ecpayInvoiceClient")
    public EcpayInvoiceClient ecpayInvoiceClient()
    {
        return EcpayInvoiceClient.builder()
                .operatingMode(ecpay.invoice.integration.OperatingMode.TEST)
                .MerchantID("2000132")
                .HashKey("ejCk326UnaZWKisg")
                .HashIV("q9jcZX8Ib9LM8wYk")
                .build();
    }

    @Bean(name = "ecpayPaymentClient")
    public EcpayPaymentClient ecpayPaymentClient()
    {
        return EcpayPaymentClient.builder()
                .operatingMode(ecpay.payment.integration.OperatingMode.TEST)
                .MerchantID("2000132")
                .HashKey("5294y06JbISpM5x9")
                .HashIV("v77hoKGq4kWxNNIS")
                .build();
    }
}
