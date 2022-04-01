/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.model;


import com.bcorp.polaris.model.tables.Book;
import com.bcorp.polaris.model.tables.BookCategory;
import com.bcorp.polaris.model.tables.BookReview;
import com.bcorp.polaris.model.tables.Cart;
import com.bcorp.polaris.model.tables.CartLineItem;
import com.bcorp.polaris.model.tables.Chapter;
import com.bcorp.polaris.model.tables.FlywaySchemaHistory;
import com.bcorp.polaris.model.tables.Order;
import com.bcorp.polaris.model.tables.OrderLineItem;
import com.bcorp.polaris.model.tables.Page;
import com.bcorp.polaris.model.tables.PaymentMode;
import com.bcorp.polaris.model.tables.User;
import com.bcorp.polaris.model.tables.UserBookshelf;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PolarisDb extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db</code>
     */
    public static final PolarisDb POLARIS_DB = new PolarisDb();

    /**
     * The table <code>polaris-db.book</code>.
     */
    public final Book BOOK = Book.BOOK;

    /**
     * The table <code>polaris-db.book_category</code>.
     */
    public final BookCategory BOOK_CATEGORY = BookCategory.BOOK_CATEGORY;

    /**
     * The table <code>polaris-db.book_review</code>.
     */
    public final BookReview BOOK_REVIEW = BookReview.BOOK_REVIEW;

    /**
     * The table <code>polaris-db.cart</code>.
     */
    public final Cart CART = Cart.CART;

    /**
     * The table <code>polaris-db.cart_line_item</code>.
     */
    public final CartLineItem CART_LINE_ITEM = CartLineItem.CART_LINE_ITEM;

    /**
     * The table <code>polaris-db.chapter</code>.
     */
    public final Chapter CHAPTER = Chapter.CHAPTER;

    /**
     * The table <code>polaris-db.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>polaris-db.order</code>.
     */
    public final Order ORDER = Order.ORDER;

    /**
     * The table <code>polaris-db.order_line_item</code>.
     */
    public final OrderLineItem ORDER_LINE_ITEM = OrderLineItem.ORDER_LINE_ITEM;

    /**
     * The table <code>polaris-db.page</code>.
     */
    public final Page PAGE = Page.PAGE;

    /**
     * The table <code>polaris-db.payment_mode</code>.
     */
    public final PaymentMode PAYMENT_MODE = PaymentMode.PAYMENT_MODE;

    /**
     * The table <code>polaris-db.user</code>.
     */
    public final User USER = User.USER;

    /**
     * The table <code>polaris-db.user_bookshelf</code>.
     */
    public final UserBookshelf USER_BOOKSHELF = UserBookshelf.USER_BOOKSHELF;

    /**
     * No further instances allowed
     */
    private PolarisDb() {
        super("polaris-db", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            Book.BOOK,
            BookCategory.BOOK_CATEGORY,
            BookReview.BOOK_REVIEW,
            Cart.CART,
            CartLineItem.CART_LINE_ITEM,
            Chapter.CHAPTER,
            FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
            Order.ORDER,
            OrderLineItem.ORDER_LINE_ITEM,
            Page.PAGE,
            PaymentMode.PAYMENT_MODE,
            User.USER,
            UserBookshelf.USER_BOOKSHELF
        );
    }
}
