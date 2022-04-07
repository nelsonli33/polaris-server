package com.bcorp.polaris.storefront.service;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CartService
{
    CartRecord getCartForCurrentUser();

    Map<CartRecord, List<CartLineItemRecord>> getCartDetailForCurrentUser();

    CartLineItemRecord addCartLineItem(CartRecord cartRecord, BookRecord bookRecord);

    Optional<CartLineItemRecord> getCartLineItem(CartRecord cartRecord, BookRecord bookRecord);

    List<CartLineItemRecord> getAllCartLineItemsForCart(CartRecord cartRecord);
}
