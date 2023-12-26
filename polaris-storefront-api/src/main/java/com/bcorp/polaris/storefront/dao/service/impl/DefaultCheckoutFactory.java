package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.dao.service.CartService;
import com.bcorp.polaris.storefront.dao.service.CheckoutFactory;
import com.bcorp.polaris.storefront.dto.PlaceOrderDto;
import org.springframework.stereotype.Component;

@Component(value = "checkoutFactory")
public class DefaultCheckoutFactory implements CheckoutFactory
{
    private CartService cartService;

    public DefaultCheckoutFactory(CartService cartService)
    {
        this.cartService = cartService;
    }

    @Override
    public CheckoutBo createCheckoutBo(PlaceOrderDto placeOrderDto)
    {
        final CartBo cartBo = cartService.getCartBo();

        CheckoutBo checkoutBo = new CheckoutBo();
        checkoutBo.setCart(cartBo.getCart());
        checkoutBo.setCartLineItems(cartBo.getLineItems());
        checkoutBo.setPaymentType(placeOrderDto.getPaymentType());

        if (placeOrderDto.getInvoiceDto() != null)
        {
            checkoutBo.setInvoiceDto(placeOrderDto.getInvoiceDto());
        }
        return checkoutBo;
    }
}
