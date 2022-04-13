package com.bcorp.polaris.storefront.service.impl;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;
import com.bcorp.polaris.core.model.tables.records.OrderLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.bo.OrderBo;
import com.bcorp.polaris.storefront.dao.OrderDao;
import com.bcorp.polaris.storefront.service.OrderService;
import com.bcorp.polaris.storefront.service.strategy.CreateOrderFromCheckoutStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(value = "orderService")
public class DefaultOrderService implements OrderService
{
    private OrderDao orderDao;
    private CreateOrderFromCheckoutStrategy createOrderFromCheckoutStrategy;

    @Autowired
    public DefaultOrderService(
            OrderDao orderDao,
            CreateOrderFromCheckoutStrategy createOrderFromCheckoutStrategy)
    {
        this.orderDao = orderDao;
        this.createOrderFromCheckoutStrategy = createOrderFromCheckoutStrategy;
    }


    public OrderBo getOrderBoForCode(String orderCode)
    {
        Map<OrderRecord, List<OrderLineItemRecord>> recordMap = orderDao.findOrderAndLineItemsByCode(orderCode);

        final OrderBo orderBo = recordMap.entrySet().stream().map(e -> {
            OrderBo order = new OrderBo();
            order.setOrder(e.getKey());
            order.setLineItems(e.getValue());
            return order;
        }).findFirst().orElse(null);

        if (orderBo == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.ORDER_NOT_FOUND, "Order with code:[" + orderCode + "] not found.");
        }

        return orderBo;
    }

    @Override
    @Transactional
    public OrderRecord createOrderFromCheckout(CheckoutBo checkoutBo)
    {
        return createOrderFromCheckoutStrategy.createOrderFromCheckout(checkoutBo);
    }
}
