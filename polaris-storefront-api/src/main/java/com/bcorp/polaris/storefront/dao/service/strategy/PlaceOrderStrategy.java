package com.bcorp.polaris.storefront.dao.service.strategy;

import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;

public interface PlaceOrderStrategy
{
    OrderRecord placeOrder(CheckoutBo checkoutBo);
}
