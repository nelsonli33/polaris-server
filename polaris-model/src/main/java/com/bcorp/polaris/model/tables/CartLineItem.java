/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.model.tables;


import com.bcorp.polaris.model.Keys;
import com.bcorp.polaris.model.PolarisDb;
import com.bcorp.polaris.model.tables.records.CartLineItemRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CartLineItem extends TableImpl<CartLineItemRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.cart_line_item</code>
     */
    public static final CartLineItem CART_LINE_ITEM = new CartLineItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CartLineItemRecord> getRecordType() {
        return CartLineItemRecord.class;
    }

    /**
     * The column <code>polaris-db.cart_line_item.id</code>.
     */
    public final TableField<CartLineItemRecord, ULong> ID = createField(DSL.name("id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.cart_line_item.cart_id</code>. 購物車 id
     */
    public final TableField<CartLineItemRecord, ULong> CART_ID = createField(DSL.name("cart_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "購物車 id");

    /**
     * The column <code>polaris-db.cart_line_item.name</code>. 商品名稱
     */
    public final TableField<CartLineItemRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "商品名稱");

    /**
     * The column <code>polaris-db.cart_line_item.price</code>. 商品金額
     */
    public final TableField<CartLineItemRecord, BigDecimal> PRICE = createField(DSL.name("price"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品金額");

    /**
     * The column <code>polaris-db.cart_line_item.quantity</code>.
     */
    public final TableField<CartLineItemRecord, Integer> QUANTITY = createField(DSL.name("quantity"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>polaris-db.cart_line_item.subtotal</code>. 商品小計
     */
    public final TableField<CartLineItemRecord, BigDecimal> SUBTOTAL = createField(DSL.name("subtotal"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品小計");

    /**
     * The column <code>polaris-db.cart_line_item.total_discounts</code>. 商品總折扣
     */
    public final TableField<CartLineItemRecord, BigDecimal> TOTAL_DISCOUNTS = createField(DSL.name("total_discounts"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品總折扣");

    /**
     * The column <code>polaris-db.cart_line_item.total_price</code>. 商品總金額
     */
    public final TableField<CartLineItemRecord, BigDecimal> TOTAL_PRICE = createField(DSL.name("total_price"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品總金額");

    /**
     * The column <code>polaris-db.cart_line_item.created_at</code>. 建立時間
     */
    public final TableField<CartLineItemRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.cart_line_item.updated_at</code>. 修改時間
     */
    public final TableField<CartLineItemRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private CartLineItem(Name alias, Table<CartLineItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private CartLineItem(Name alias, Table<CartLineItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.cart_line_item</code> table reference
     */
    public CartLineItem(String alias) {
        this(DSL.name(alias), CART_LINE_ITEM);
    }

    /**
     * Create an aliased <code>polaris-db.cart_line_item</code> table reference
     */
    public CartLineItem(Name alias) {
        this(alias, CART_LINE_ITEM);
    }

    /**
     * Create a <code>polaris-db.cart_line_item</code> table reference
     */
    public CartLineItem() {
        this(DSL.name("cart_line_item"), null);
    }

    public <O extends Record> CartLineItem(Table<O> child, ForeignKey<O, CartLineItemRecord> key) {
        super(child, key, CART_LINE_ITEM);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<CartLineItemRecord, ULong> getIdentity() {
        return (Identity<CartLineItemRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<CartLineItemRecord> getPrimaryKey() {
        return Keys.KEY_CART_LINE_ITEM_PRIMARY;
    }

    @Override
    public CartLineItem as(String alias) {
        return new CartLineItem(DSL.name(alias), this);
    }

    @Override
    public CartLineItem as(Name alias) {
        return new CartLineItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CartLineItem rename(String name) {
        return new CartLineItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CartLineItem rename(Name name) {
        return new CartLineItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<ULong, ULong, String, BigDecimal, Integer, BigDecimal, BigDecimal, BigDecimal, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
