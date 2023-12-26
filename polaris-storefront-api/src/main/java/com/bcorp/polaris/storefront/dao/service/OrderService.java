package com.bcorp.polaris.storefront.dao.service;

import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.bo.OrderBo;

public interface OrderService
{
    OrderBo getOrderBoForCode(String orderCode);

    OrderRecord createOrderFromCheckout(CheckoutBo checkoutBo);
}
