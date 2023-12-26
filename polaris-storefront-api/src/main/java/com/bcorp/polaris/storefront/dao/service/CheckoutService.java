package com.bcorp.polaris.storefront.dao.service;

import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;

public interface CheckoutService
{
    OrderRecord placeOrder(CheckoutBo checkoutBo);
}
