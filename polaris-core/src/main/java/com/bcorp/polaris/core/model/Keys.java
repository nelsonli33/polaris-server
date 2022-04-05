/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model;


import com.bcorp.polaris.core.model.tables.Book;
import com.bcorp.polaris.core.model.tables.BookCategory;
import com.bcorp.polaris.core.model.tables.BookCategoryRel;
import com.bcorp.polaris.core.model.tables.BookReview;
import com.bcorp.polaris.core.model.tables.Cart;
import com.bcorp.polaris.core.model.tables.CartLineItem;
import com.bcorp.polaris.core.model.tables.Chapter;
import com.bcorp.polaris.core.model.tables.FlywaySchemaHistory;
import com.bcorp.polaris.core.model.tables.Order;
import com.bcorp.polaris.core.model.tables.OrderLineItem;
import com.bcorp.polaris.core.model.tables.Page;
import com.bcorp.polaris.core.model.tables.PaymentMode;
import com.bcorp.polaris.core.model.tables.User;
import com.bcorp.polaris.core.model.tables.UserBookshelf;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRecord;
import com.bcorp.polaris.core.model.tables.records.BookCategoryRelRecord;
import com.bcorp.polaris.core.model.tables.records.BookRecord;
import com.bcorp.polaris.core.model.tables.records.BookReviewRecord;
import com.bcorp.polaris.core.model.tables.records.CartLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.CartRecord;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import com.bcorp.polaris.core.model.tables.records.FlywaySchemaHistoryRecord;
import com.bcorp.polaris.core.model.tables.records.OrderLineItemRecord;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import com.bcorp.polaris.core.model.tables.records.PageRecord;
import com.bcorp.polaris.core.model.tables.records.PaymentModeRecord;
import com.bcorp.polaris.core.model.tables.records.UserBookshelfRecord;
import com.bcorp.polaris.core.model.tables.records.UserRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * polaris-db.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<BookRecord> KEY_BOOK_PRIMARY = Internal.createUniqueKey(Book.BOOK, DSL.name("KEY_book_PRIMARY"), new TableField[] { Book.BOOK.ID }, true);
    public static final UniqueKey<BookCategoryRecord> KEY_BOOK_CATEGORY_PRIMARY = Internal.createUniqueKey(BookCategory.BOOK_CATEGORY, DSL.name("KEY_book_category_PRIMARY"), new TableField[] { BookCategory.BOOK_CATEGORY.ID }, true);
    public static final UniqueKey<BookCategoryRelRecord> KEY_BOOK_CATEGORY_REL_UK_BOOK_CATEGORY = Internal.createUniqueKey(BookCategoryRel.BOOK_CATEGORY_REL, DSL.name("KEY_book_category_rel_uk_book_category"), new TableField[] { BookCategoryRel.BOOK_CATEGORY_REL.BOOK_ID, BookCategoryRel.BOOK_CATEGORY_REL.BOOK_CATEGORY_ID }, true);
    public static final UniqueKey<BookReviewRecord> KEY_BOOK_REVIEW_PRIMARY = Internal.createUniqueKey(BookReview.BOOK_REVIEW, DSL.name("KEY_book_review_PRIMARY"), new TableField[] { BookReview.BOOK_REVIEW.ID }, true);
    public static final UniqueKey<CartRecord> KEY_CART_PRIMARY = Internal.createUniqueKey(Cart.CART, DSL.name("KEY_cart_PRIMARY"), new TableField[] { Cart.CART.ID }, true);
    public static final UniqueKey<CartRecord> KEY_CART_UK_CART_CODE = Internal.createUniqueKey(Cart.CART, DSL.name("KEY_cart_uk_cart_code"), new TableField[] { Cart.CART.CODE }, true);
    public static final UniqueKey<CartLineItemRecord> KEY_CART_LINE_ITEM_PRIMARY = Internal.createUniqueKey(CartLineItem.CART_LINE_ITEM, DSL.name("KEY_cart_line_item_PRIMARY"), new TableField[] { CartLineItem.CART_LINE_ITEM.ID }, true);
    public static final UniqueKey<ChapterRecord> KEY_CHAPTER_PRIMARY = Internal.createUniqueKey(Chapter.CHAPTER, DSL.name("KEY_chapter_PRIMARY"), new TableField[] { Chapter.CHAPTER.ID }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> KEY_FLYWAY_SCHEMA_HISTORY_PRIMARY = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("KEY_flyway_schema_history_PRIMARY"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<OrderRecord> KEY_ORDER_PRIMARY = Internal.createUniqueKey(Order.ORDER, DSL.name("KEY_order_PRIMARY"), new TableField[] { Order.ORDER.ID }, true);
    public static final UniqueKey<OrderRecord> KEY_ORDER_UK_ORDER_CODE = Internal.createUniqueKey(Order.ORDER, DSL.name("KEY_order_uk_order_code"), new TableField[] { Order.ORDER.CODE }, true);
    public static final UniqueKey<OrderLineItemRecord> KEY_ORDER_LINE_ITEM_PRIMARY = Internal.createUniqueKey(OrderLineItem.ORDER_LINE_ITEM, DSL.name("KEY_order_line_item_PRIMARY"), new TableField[] { OrderLineItem.ORDER_LINE_ITEM.ID }, true);
    public static final UniqueKey<PageRecord> KEY_PAGE_PRIMARY = Internal.createUniqueKey(Page.PAGE, DSL.name("KEY_page_PRIMARY"), new TableField[] { Page.PAGE.ID }, true);
    public static final UniqueKey<PaymentModeRecord> KEY_PAYMENT_MODE_PRIMARY = Internal.createUniqueKey(PaymentMode.PAYMENT_MODE, DSL.name("KEY_payment_mode_PRIMARY"), new TableField[] { PaymentMode.PAYMENT_MODE.ID }, true);
    public static final UniqueKey<PaymentModeRecord> KEY_PAYMENT_MODE_UK_PAYMENT_MODE_CODE = Internal.createUniqueKey(PaymentMode.PAYMENT_MODE, DSL.name("KEY_payment_mode_uk_payment_mode_code"), new TableField[] { PaymentMode.PAYMENT_MODE.CODE }, true);
    public static final UniqueKey<UserRecord> KEY_USER_PRIMARY = Internal.createUniqueKey(User.USER, DSL.name("KEY_user_PRIMARY"), new TableField[] { User.USER.ID }, true);
    public static final UniqueKey<UserRecord> KEY_USER_UK_EMAIL = Internal.createUniqueKey(User.USER, DSL.name("KEY_user_uk_email"), new TableField[] { User.USER.EMAIL }, true);
    public static final UniqueKey<UserRecord> KEY_USER_UK_UID = Internal.createUniqueKey(User.USER, DSL.name("KEY_user_uk_uid"), new TableField[] { User.USER.UID }, true);
    public static final UniqueKey<UserBookshelfRecord> KEY_USER_BOOKSHELF_PRIMARY = Internal.createUniqueKey(UserBookshelf.USER_BOOKSHELF, DSL.name("KEY_user_bookshelf_PRIMARY"), new TableField[] { UserBookshelf.USER_BOOKSHELF.ID }, true);
}
