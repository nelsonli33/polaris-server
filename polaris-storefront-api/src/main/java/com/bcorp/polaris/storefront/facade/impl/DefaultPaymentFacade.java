package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.model.tables.records.OrderLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.core.util.EnumUtil;
import com.bcorp.polaris.storefront.bo.OrderBo;
import com.bcorp.polaris.storefront.constant.PaymentType;
import com.bcorp.polaris.storefront.dao.service.EcpayPaymentService;
import com.bcorp.polaris.storefront.dao.service.OrderService;
import com.bcorp.polaris.storefront.dto.PaymentDto;
import com.bcorp.polaris.storefront.facade.PaymentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component(value = "paymentFacade")
public class DefaultPaymentFacade implements PaymentFacade
{
    @Value("${polaris.app.backend.domain}")
    private static final String BACKEND_DOMAIN = "";
    @Value("${polaris.app.frontend.domain}")
    private static final String FRONTEND_DOMAIN = "";
    private static final String TRADE_DESC = "購物";
    private static final String RETURN_URL = "/checkout/ecpay/payment/callback";
    private static final String CLIENT_BACK_URL = "/checkout/ecpay/payment/client-back";
    private static final String ORDER_RESULT_URL = "/checkout/ecpay/payment/order-result";

    private OrderService orderService;
    private EcpayPaymentService ecpayPaymentService;

    @Autowired
    public DefaultPaymentFacade(OrderService orderService, EcpayPaymentService ecpayPaymentService)
    {
        this.orderService = orderService;
        this.ecpayPaymentService = ecpayPaymentService;
    }

    public PaymentDto startEcpayPayment(String orderCode)
    {
        final String returnUrl = BACKEND_DOMAIN + RETURN_URL;
        final String clientBackUrl = FRONTEND_DOMAIN + CLIENT_BACK_URL + "?orderCode=" + orderCode;
        final String orderResultUrl = BACKEND_DOMAIN + ORDER_RESULT_URL;

        final OrderBo orderBo = orderService.getOrderBoForCode(orderCode);
        final OrderRecord order = orderBo.getOrder();
        final PaymentType paymentType = EnumUtil.getByCode(order.getPaymentMode(), PaymentType.class);

        String totalPrice = String.valueOf(order.getTotalPrice().intValue());
        String itemName = orderBo.getLineItems().stream().map(OrderLineItemRecord::getName)
                .collect(Collectors.joining("#"));

        String postForm = "";
        switch (paymentType)
        {
            case CREDIT_CARD_ONCE:
                postForm = ecpayPaymentService.genCreditOnceCheckoutForm(order.getCode(), totalPrice, itemName, TRADE_DESC, returnUrl, orderResultUrl, clientBackUrl);
                break;
        }

        return PaymentDto.builder().checkoutForm(postForm).build();
    }
}
