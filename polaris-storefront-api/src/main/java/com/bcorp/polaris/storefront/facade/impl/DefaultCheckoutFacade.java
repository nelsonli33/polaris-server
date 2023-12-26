package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.core.dto.OrderDto;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.bo.CheckoutBo;
import com.bcorp.polaris.storefront.constant.PaymentType;
import com.bcorp.polaris.storefront.dao.service.CartService;
import com.bcorp.polaris.storefront.dao.service.CheckoutFactory;
import com.bcorp.polaris.storefront.dao.service.CheckoutService;
import com.bcorp.polaris.storefront.dto.CheckoutDto;
import com.bcorp.polaris.storefront.dto.PaymentModeDto;
import com.bcorp.polaris.storefront.dto.PlaceOrderDto;
import com.bcorp.polaris.storefront.facade.CheckoutFacade;
import com.bcorp.polaris.storefront.facade.converter.DtoConverter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "checkoutFacade")
public class DefaultCheckoutFacade implements CheckoutFacade
{
    private CartService cartService;
    private CheckoutService checkoutService;
    private CheckoutFactory checkoutFactory;
    private DtoConverter dtoConverter;

    public DefaultCheckoutFacade(
            CartService cartService,
            CheckoutService checkoutService,
            CheckoutFactory checkoutFactory,
            DtoConverter dtoConverter
    )
    {
        this.cartService = cartService;
        this.checkoutService = checkoutService;
        this.checkoutFactory = checkoutFactory;
        this.dtoConverter = dtoConverter;
    }


    @Override
    public CheckoutDto getCheckout()
    {
        final CartDto cartDto = dtoConverter.convert(getCart());

        CheckoutDto checkoutDto = new CheckoutDto();
        checkoutDto.setCart(cartDto);
        checkoutDto.setPaymentMethods(getSupportedPaymentMethods());
        checkoutDto.setDefaultPaymentMethodCode("CreditCardOnce");

        return checkoutDto;
    }

    @Override
    public List<PaymentModeDto> getSupportedPaymentMethods()
    {
        return Arrays.stream(PaymentType.values()).map(p ->
                PaymentModeDto.builder()
                        .code(p.getCode())
                        .name(p.getName())
                        .build()
        ).collect(Collectors.toList());
    }


    @Transactional
    public OrderDto placeOrder(PlaceOrderDto placeOrderDto)
    {
        final CheckoutBo checkoutBo = checkoutFactory.createCheckoutBo(placeOrderDto);

        beforePlaceOrder(checkoutBo);
        OrderRecord order = placeOrder(checkoutBo);
        afterPlaceOrder(checkoutBo);

        return dtoConverter.convert(order);
    }


    private void beforePlaceOrder(final CheckoutBo checkoutBo)
    {
        // Do nothing, extension point
    }

    private OrderRecord placeOrder(final CheckoutBo checkoutBo)
    {
        return checkoutService.placeOrder(checkoutBo);
    }

    private void afterPlaceOrder(final CheckoutBo checkoutBo)
    {
        cartService.removeCart();

        // TODO: send email
    }

    @Override
    public boolean hasValidCart()
    {
        CartBo cartBo = getCart();
        return cartBo.getCart() != null && cartBo.getLineItems() != null && !cartBo.getLineItems().isEmpty();
    }

    protected CartBo getCart()
    {
        return cartService.getCartBo();
    }
}
