package com.bcorp.polaris.storefront.service.strategy.impl;

import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.dto.CommerceCartParameter;
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
        final CartBo cartBo = parameter.getCartBo();
        validateParameterNotNull(cartBo, "CartBo cannot be null");
        calculationService.calculate(cartBo);
    }
}
