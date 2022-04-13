package com.bcorp.polaris.storefront.dao.impl;

import com.bcorp.polaris.core.model.tables.records.OrderLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.dao.OrderDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.model.tables.Order.ORDER;
import static com.bcorp.polaris.core.model.tables.OrderLineItem.ORDER_LINE_ITEM;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;
import static java.util.stream.Collectors.*;

@Repository
public class DefaultOrderDao implements OrderDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultOrderDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    public Map<OrderRecord, List<OrderLineItemRecord>> findOrderAndLineItemsByCode(String orderCode)
    {
        validateParameterNotNull(orderCode, "orderCode must not be null");
        return dslContext.select()
                .from(ORDER)
                .leftJoin(ORDER_LINE_ITEM).on(ORDER.ID.eq(ORDER_LINE_ITEM.ORDER_ID))
                .where(ORDER.CODE.eq(orderCode))
                .collect(groupingBy(
                        r -> r.into(ORDER), filtering(
                                r -> r.get(ORDER_LINE_ITEM.ID) != null, mapping(
                                        r -> r.into(ORDER_LINE_ITEM), toList()
                                )
                        )
                ));
    }
}
