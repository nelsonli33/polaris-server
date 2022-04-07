package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.CartRecord;

public interface CalculationService
{
    void calculate(CartRecord cart);
}
