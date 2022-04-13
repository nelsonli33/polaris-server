package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.storefront.bo.BookBo;
import com.bcorp.polaris.storefront.bo.CartBo;

import java.util.Optional;

public interface CartService
{
    CartRecord getCartForCurrentUser();

    boolean hasCart();

    CartBo getCartDetailForCurrentUser();

    CartBo getCartBo();

    CartLineItemRecord addCartLineItem(CartBo cartBo, BookBo bookBo);

    Optional<CartLineItemRecord> getCartLineItemForBook(CartBo cartBo, BookBo bookBo);

    void removeCart();
    
    void removeAllCartLineItems(CartRecord cartRecord);
}
