package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.core.model.tables.records.OrderLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;

import java.util.List;
import java.util.Map;

public interface OrderDao
{
    Map<OrderRecord, List<OrderLineItemRecord>> findOrderAndLineItemsByCode(String orderCode);
}
