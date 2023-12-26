package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.dao.service.CalculationService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service(value = "calculationService")
public class DefaultCalculationService implements CalculationService
{
    private DSLContext dslContext;

    @Autowired
    public DefaultCalculationService(
            DSLContext dslContext
    )
    {
        this.dslContext = dslContext;
    }

    @Override
    public void calculate(CartBo cartBo)
    {
        // -------------------------------
        // first calc all line items
        calculateLineItems(cartBo);
        // -------------------------------
        // now calculate all totals
        calculateTotals(cartBo.getCart());
    }

    private void calculateTotals(CartRecord cart)
    {
        // subtotal
        final double subtotal = cart.getSubtotal().doubleValue();

        // discounts
        final double roundedTotalDiscounts = 0;
        cart.setTotalDiscounts(BigDecimal.valueOf(roundedTotalDiscounts));

        // set total
        final double totalPrice = subtotal - roundedTotalDiscounts;
        cart.setTotalPrice(BigDecimal.valueOf(totalPrice));

        dslContext.executeUpdate(cart);
    }

    private void calculateLineItems(CartBo cartBo)
    {
        double subtotal = 0.0;
        for (CartLineItemRecord lineItem : cartBo.getLineItems())
        {
            calculateTotals(lineItem);
            subtotal += lineItem.getTotalPrice().doubleValue();
        }

        final CartRecord cart = cartBo.getCart();
        cart.setSubtotal(BigDecimal.valueOf(subtotal));
    }


    private void calculateTotals(CartLineItemRecord lineItem)
    {
        final double totalPriceWithoutDiscount =
                lineItem.getPrice().setScale(2, RoundingMode.HALF_UP).doubleValue();

        lineItem.setSubtotal(BigDecimal.valueOf(totalPriceWithoutDiscount));
        double totalPrice = totalPriceWithoutDiscount;

        // set total discounts
        lineItem.setTotalDiscounts(BigDecimal.ZERO);

        // set total price
        lineItem.setTotalPrice(BigDecimal.valueOf(totalPrice));

        dslContext.executeUpdate(lineItem);
    }
}
