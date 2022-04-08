package com.bcorp.polaris.storefront.dao.impl;

import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dao.CartDao;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.bcorp.polaris.core.model.tables.Cart.CART;
import static com.bcorp.polaris.core.model.tables.CartLineItem.CART_LINE_ITEM;
import static com.bcorp.polaris.core.util.ServicesUtil.validateParameterNotNull;
import static java.util.stream.Collectors.*;

@Repository
public class DefaultCartDao implements CartDao
{
    private DSLContext dslContext;

    @Autowired
    public DefaultCartDao(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }

    @Override
    public CartRecord findCartByUser(UserRecord userRecord)
    {
        validateParameterNotNull(userRecord, "UserRecord must not be null");
        return dslContext.fetchOne(CART, CART.USER_ID.eq(userRecord.getId()));
    }

    @Override
    public Map<CartRecord, List<CartLineItemRecord>> findCartAndLineItemsByUser(UserRecord userRecord)
    {
        validateParameterNotNull(userRecord, "UserRecord must not be null");
        return dslContext.select()
                .from(CART)
                .leftJoin(CART_LINE_ITEM).on(CART.ID.eq(CART_LINE_ITEM.CART_ID))
                .where(CART.USER_ID.eq(userRecord.getId()))
                .collect(groupingBy(
                        r -> r.into(CART), filtering(
                                r -> r.get(CART_LINE_ITEM.ID) != null, mapping(
                                        r -> r.into(CART_LINE_ITEM), toList()
                                )
                        )
                ));
    }

    @Override
    public boolean checkUserIfHasCart(UserRecord userRecord)
    {
        validateParameterNotNull(userRecord, "UserRecord must not be null");
        return dslContext.fetchExists(dslContext.selectOne().from(CART)
                .where(CART.USER_ID.eq(userRecord.getId())));
    }

    @Override
    public CartLineItemRecord findCartLineItemByCartAndBook(CartRecord cartRecord, BookRecord bookRecord)
    {
        validateParameterNotNull(cartRecord, "CartRecord cannot be null");
        validateParameterNotNull(bookRecord, "BookRecord cannot be null");
        return dslContext.fetchOne(CART_LINE_ITEM, CART_LINE_ITEM.CART_ID.eq(cartRecord.getId())
                .and(CART_LINE_ITEM.BOOK_ID.eq(bookRecord.getId())));
    }

    @Override
    public List<CartLineItemRecord> findAllCartLineItemsByCart(CartRecord cartRecord)
    {
        validateParameterNotNull(cartRecord, "CartRecord cannot be null");
        return dslContext.select().from(CART_LINE_ITEM).where(CART_LINE_ITEM.CART_ID.eq(cartRecord.getId()))
                .fetchInto(CartLineItemRecord.class);
    }

    @Override
    public void deleteAllCartItemsByCart(CartRecord cartRecord)
    {
        validateParameterNotNull(cartRecord, "CartRecord cannot be null");
        dslContext.delete(CART_LINE_ITEM).where(CART_LINE_ITEM.CART_ID.eq(cartRecord.getId())).execute();
    }

}
