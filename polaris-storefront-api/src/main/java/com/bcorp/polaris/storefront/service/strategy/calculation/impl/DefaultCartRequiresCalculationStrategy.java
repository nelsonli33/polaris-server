package com.bcorp.polaris.storefront.service.strategy.calculation.impl;

import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.storefront.constant.CartLineItemStatus;
import com.bcorp.polaris.storefront.service.strategy.calculation.CartRequiresCalculationStrategy;
import org.springframework.stereotype.Component;

@Component(value = "cartRequiresCalculationStrategy")
public class DefaultCartRequiresCalculationStrategy implements CartRequiresCalculationStrategy
{
    @Override
    public boolean requiresCalculation(CartLineItemRecord cartLineItem)
    {
        return CartLineItemStatus.PUBLISHED.equals(CartLineItemStatus.fromValue(cartLineItem.getStatus()));
    }
}
