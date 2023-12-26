package com.bcorp.polaris.storefront.facade.impl;

import com.bcorp.polaris.core.dto.CartDto;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.bo.CartBo;
import com.bcorp.polaris.storefront.dao.service.BookService;
import com.bcorp.polaris.storefront.dao.service.CartService;
import com.bcorp.polaris.storefront.dao.service.CommerceCartService;
import com.bcorp.polaris.storefront.dto.CommerceCartParameter;
import com.bcorp.polaris.storefront.facade.CartFacade;
import com.bcorp.polaris.storefront.facade.converter.DtoConverter;
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
    public CartDto getCartForCurrentUser()
    {
        return dtoConverter.convert(cartService.getCartDetailForCurrentUser());
    }

    @Override
    public CartDto addToCart(Long bookId)
    {
        final CommerceCartParameter parameter = convertToCommerceCartParameter(bookId);
        commerceCartService.addToCart(parameter);
        return dtoConverter.convert(parameter.getCartBo());
    }

    @Override
    public CartDto removeLineItem(Long bookId)
    {
        final CommerceCartParameter parameter = convertToCommerceCartParameter(bookId);
        commerceCartService.removeCartLineItem(parameter);
        return dtoConverter.convert(cartService.getCartDetailForCurrentUser());
    }

    @Override
    public CartDto clearCart()
    {
        final CommerceCartParameter parameter = new CommerceCartParameter();
        parameter.setCartBo(cartService.getCartBo());
        commerceCartService.removeAllCartLineItems(parameter);
        return dtoConverter.convert(cartService.getCartDetailForCurrentUser());
    }

    @Override
    public boolean validateCartIsValid()
    {
        final CommerceCartParameter parameter = new CommerceCartParameter();
        parameter.setCartBo(cartService.getCartBo());
        return commerceCartService.validateCartIsValid(parameter);
    }


    private CommerceCartParameter convertToCommerceCartParameter(Long bookId)
    {
        final BookRecord bookRecord = bookService.getBookForId(bookId);
        final BookBo bookBo = bookService.getBookBo(bookRecord);
        final CartBo cartBo = cartService.getCartBo();

        CommerceCartParameter parameter = new CommerceCartParameter();
        parameter.setCartBo(cartBo);
        parameter.setBookBo(bookBo);
        return parameter;
    }
}
