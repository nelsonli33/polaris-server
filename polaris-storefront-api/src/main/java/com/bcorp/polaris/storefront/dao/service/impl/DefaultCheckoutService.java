package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.dao.service.CheckoutService;
import com.bcorp.polaris.storefront.dao.service.strategy.PlaceOrderStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "checkoutService")
public class DefaultCheckoutService implements CheckoutService
{
    private PlaceOrderStrategy placeOrderStrategy;

    @Autowired
    public DefaultCheckoutService(PlaceOrderStrategy placeOrderStrategy)
    {
        this.placeOrderStrategy = placeOrderStrategy;
    }

    @Override
    public OrderRecord placeOrder(CheckoutBo checkoutBo)
    {
        return placeOrderStrategy.placeOrder(checkoutBo);
    }
}
