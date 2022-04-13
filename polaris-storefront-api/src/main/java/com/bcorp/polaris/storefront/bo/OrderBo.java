package com.bcorp.polaris.storefront.bo;

import com.bcorp.polaris.core.model.tables.records.OrderLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBo
{
    private OrderRecord order;
    private List<OrderLineItemRecord> lineItems;
}
