package com.bcorp.polaris.storefront.dao;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;

import java.util.List;
import java.util.Map;

public interface CartDao
{
    CartRecord findCartByUser(UserRecord userRecord);

    Map<CartRecord, List<CartLineItemRecord>> findCartAndLineItemsByUser(UserRecord userRecord);

    CartLineItemRecord findCartLineItemByCartAndBook(CartRecord cartRecord, BookRecord bookRecord);

    List<CartLineItemRecord> findAllCartLineItemsByCart(CartRecord cartRecord);
}
