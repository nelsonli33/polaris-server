package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.dto.cart.CommerceCartParameter;
import com.bcorp.polaris.storefront.facade.CartFacade;
import com.bcorp.polaris.storefront.facade.converter.DtoConverter;
import com.bcorp.polaris.storefront.service.BookService;
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
    private DtoConverter dtoConverter;

    @Autowired
    public DefaultCartFacade(CommerceCartService commerceCartService,
                             CartService cartService,
                             BookService bookService,
                             DtoConverter dtoConverter)
    {
        this.commerceCartService = commerceCartService;
        this.cartService = cartService;
        this.bookService = bookService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public CartDto addToCart(Long bookId)
    {
        final CommerceCartParameter commerceCartParameter = convertToCommerceCartParameter(bookId);

        commerceCartService.addToCart(commerceCartParameter);

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
