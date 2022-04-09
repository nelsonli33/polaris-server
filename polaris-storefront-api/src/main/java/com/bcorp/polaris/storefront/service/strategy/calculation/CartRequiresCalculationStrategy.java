package com.bcorp.polaris.storefront.service.strategy.calculation;

import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;

/**
 * Strategy answers if cart line item requires calculation
 */
public interface CartRequiresCalculationStrategy
{
    /**
     * Method checks if the cart line item need to be calculated.
     *
     * @param cartLineItem {@link CartLineItemRecord} to check
     * @return <code>true</code> if cart line item requires calculation
     */
    boolean requiresCalculation(CartLineItemRecord cartLineItem);
}
