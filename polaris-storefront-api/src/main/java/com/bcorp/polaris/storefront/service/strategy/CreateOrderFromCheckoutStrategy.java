package com.bcorp.polaris.storefront.service.strategy;

import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;

public interface CreateOrderFromCheckoutStrategy
{
    OrderRecord createOrderFromCheckout(CheckoutBo checkoutBo);
}
