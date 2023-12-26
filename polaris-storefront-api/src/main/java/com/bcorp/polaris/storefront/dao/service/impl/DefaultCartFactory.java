package com.bcorp.polaris.storefront.dao.service.impl;

import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import com.bcorp.polaris.storefront.dao.service.CartFactory;
import com.bcorp.polaris.storefront.dao.service.UserService;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.bcorp.polaris.core.model.tables.Cart.CART;

@Component(value = "cartFactory")
public class DefaultCartFactory implements CartFactory
{
    private UserService userService;
    private DSLContext dslContext;

    @Autowired
    public DefaultCartFactory(UserService userService, DSLContext dslContext)
    {
        this.userService = userService;
        this.dslContext = dslContext;
    }

    @Override
    public CartRecord createCart()
    {
        final UserRecord currentUser = userService.getCurrentUser();
        final CartRecord cart = dslContext.newRecord(CART);
        cart.setUserId(currentUser.getId());
        cart.store();
        return cart;
    }
}
