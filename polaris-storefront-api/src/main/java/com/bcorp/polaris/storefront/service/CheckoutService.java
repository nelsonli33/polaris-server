package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;

public interface CheckoutService
{
    OrderRecord placeOrder(CheckoutBo checkoutBo);
}
