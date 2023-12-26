package com.bcorp.polaris.storefront.dao.service.strategy.impl;

import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.dao.service.OrderService;
import com.bcorp.polaris.storefront.dao.service.UserService;
import com.bcorp.polaris.storefront.dao.service.strategy.PlaceOrderStrategy;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNullStandardMessage;

@Component(value = "placeOrderStrategy")
public class DefaultPlaceOrderStrategy implements PlaceOrderStrategy
{
    private OrderService orderService;
    private UserService userService;
    private DSLContext dslContext;

    @Autowired
    public DefaultPlaceOrderStrategy(OrderService orderService,
                                     UserService userService,
                                     DSLContext dslContext)
    {
        this.orderService = orderService;
        this.userService = userService;
        this.dslContext = dslContext;
    }

    @Override
    public OrderRecord placeOrder(CheckoutBo checkoutBo)
    {
        validateParameterNotNullStandardMessage("checkoutBo", checkoutBo);
        final OrderRecord order = orderService.createOrderFromCheckout(checkoutBo);
        saveCheckoutInfoForUser(checkoutBo);
        return order;
    }

    protected void saveCheckoutInfoForUser(CheckoutBo checkoutBo)
    {
        final UserRecord currentUser = userService.getCurrentUser();
        currentUser.setDefaultPaymentMode(checkoutBo.getPaymentType().getCode());
        if (checkoutBo.getInvoiceDto() != null && checkoutBo.getInvoiceDto().getInvoiceType() != null)
        {
            currentUser.setDefaultInvoiceType(checkoutBo.getInvoiceDto().getInvoiceType().getCode().byteValue());
        }
        dslContext.executeUpdate(currentUser);
    }
}
