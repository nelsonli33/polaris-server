package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;
import com.bcorp.polaris.storefront.facade.CartFacade;
import com.bcorp.polaris.storefront.facade.converter.DtoConverter;
import com.bcorp.polaris.storefront.service.BookService;
import com.bcorp.polaris.storefront.service.CalculationService;
import com.bcorp.polaris.storefront.service.CartService;
import com.bcorp.polaris.storefront.service.CommerceCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "cartFacade")
public class DefaultCartFacade implements CartFacade
{
    private CommerceCartService commerceCartService;
    private CartService cartService;
    private BookService bookService;
    private CalculationService calculationService;
    private DtoConverter dtoConverter;

    @Autowired
    public DefaultCartFacade(CommerceCartService commerceCartService,
                             CartService cartService,
                             BookService bookService,
                             CalculationService calculationService,
                             DtoConverter dtoConverter)
    {
        this.commerceCartService = commerceCartService;
        this.cartService = cartService;
        this.bookService = bookService;
        this.calculationService = calculationService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public CartDto getCartForCurrentUser()
    {
        final CartRecord cart = cartService.getCartForCurrentUser();
        calculationService.calculate(cart);
        return dtoConverter.convert(cartService.getCartDetailForCurrentUser());
    }

    @Override
    public CartDto addToCart(Long bookId)
    {
        final CommerceCartParameter commerceCartParameter = convertToCommerceCartParameter(bookId);

        commerceCartService.addToCart(commerceCartParameter);

        return dtoConverter.convert(cartService.getCartDetailForCurrentUser());
    }

    @Override
    public CartDto removeLineItem(Long bookId)
    {
        final CommerceCartParameter commerceCartParameter = convertToCommerceCartParameter(bookId);
        commerceCartService.removeCartLineItem(commerceCartParameter);
        return dtoConverter.convert(cartService.getCartDetailForCurrentUser());
    }

    @Override
    public CartDto clearCart()
    {
        final CommerceCartParameter parameter = new CommerceCartParameter();
        parameter.setCart(cartService.getCartForCurrentUser());

        commerceCartService.removeAllCartLineItems(parameter);
        return dtoConverter.convert(cartService.getCartDetailForCurrentUser());
    }


    private CommerceCartParameter convertToCommerceCartParameter(Long bookId)
    {
        final BookRecord book = bookService.getBookForId(bookId);
        final CartRecord cart = cartService.getCartForCurrentUser();

        CommerceCartParameter parameter = new CommerceCartParameter();
        parameter.setCart(cart);
        parameter.setBook(book);
        return parameter;
    }
}
