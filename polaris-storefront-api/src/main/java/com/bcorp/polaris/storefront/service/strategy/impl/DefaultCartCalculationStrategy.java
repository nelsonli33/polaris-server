package com.bcorp.polaris.storefront.service.strategy.impl;

import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;
import com.bcorp.polaris.storefront.service.CalculationService;
import com.bcorp.polaris.storefront.service.strategy.CartCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;

@Component(value = "cartCalculationStrategy")
public class DefaultCartCalculationStrategy implements CartCalculationStrategy
{
    private CalculationService calculationService;

    @Autowired
    public DefaultCartCalculationStrategy(CalculationService calculationService)
    {
        this.calculationService = calculationService;
    }

    @Override
    public void calculateCart(CommerceCartParameter parameter)
    {
        final CartRecord cart = parameter.getCart();
        validateParameterNotNull(cart, "Cart entity cannot be null");
        calculationService.calculate(cart);
    }
}
