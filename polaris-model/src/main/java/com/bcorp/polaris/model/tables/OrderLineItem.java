/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.model.tables;


import com.bcorp.polaris.model.Keys;
import com.bcorp.polaris.model.PolarisDb;
import com.bcorp.polaris.model.tables.records.OrderLineItemRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row12;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UByte;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderLineItem extends TableImpl<OrderLineItemRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.order_line_item</code>
     */
    public static final OrderLineItem ORDER_LINE_ITEM = new OrderLineItem();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderLineItemRecord> getRecordType() {
        return OrderLineItemRecord.class;
    }

    /**
     * The column <code>polaris-db.order_line_item.id</code>.
     */
    public final TableField<OrderLineItemRecord, ULong> ID = createField(DSL.name("id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.order_line_item.order_id</code>.
     */
    public final TableField<OrderLineItemRecord, ULong> ORDER_ID = createField(DSL.name("order_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>polaris-db.order_line_item.book_id</code>.
     */
    public final TableField<OrderLineItemRecord, ULong> BOOK_ID = createField(DSL.name("book_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>polaris-db.order_line_item.name</code>. 商品名稱
     */
    public final TableField<OrderLineItemRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "商品名稱");

    /**
     * The column <code>polaris-db.order_line_item.price</code>. 商品金額
     */
    public final TableField<OrderLineItemRecord, BigDecimal> PRICE = createField(DSL.name("price"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品金額");

    /**
     * The column <code>polaris-db.order_line_item.quantity</code>.
     */
    public final TableField<OrderLineItemRecord, Integer> QUANTITY = createField(DSL.name("quantity"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("1", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>polaris-db.order_line_item.subtotal</code>. 商品小計
     */
    public final TableField<OrderLineItemRecord, BigDecimal> SUBTOTAL = createField(DSL.name("subtotal"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品小計");

    /**
     * The column <code>polaris-db.order_line_item.total_discounts</code>. 商品總折扣
     */
    public final TableField<OrderLineItemRecord, BigDecimal> TOTAL_DISCOUNTS = createField(DSL.name("total_discounts"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品總折扣");

    /**
     * The column <code>polaris-db.order_line_item.total_price</code>. 商品總金額
     */
    public final TableField<OrderLineItemRecord, BigDecimal> TOTAL_PRICE = createField(DSL.name("total_price"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "商品總金額");

    /**
     * The column <code>polaris-db.order_line_item.is_deleted</code>. 訂單商品禁止刪除
     */
    public final TableField<OrderLineItemRecord, UByte> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "訂單商品禁止刪除");

    /**
     * The column <code>polaris-db.order_line_item.created_at</code>. 建立時間
     */
    public final TableField<OrderLineItemRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.order_line_item.updated_at</code>. 修改時間
     */
    public final TableField<OrderLineItemRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private OrderLineItem(Name alias, Table<OrderLineItemRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderLineItem(Name alias, Table<OrderLineItemRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.order_line_item</code> table reference
     */
    public OrderLineItem(String alias) {
        this(DSL.name(alias), ORDER_LINE_ITEM);
    }

    /**
     * Create an aliased <code>polaris-db.order_line_item</code> table reference
     */
    public OrderLineItem(Name alias) {
        this(alias, ORDER_LINE_ITEM);
    }

    /**
     * Create a <code>polaris-db.order_line_item</code> table reference
     */
    public OrderLineItem() {
        this(DSL.name("order_line_item"), null);
    }

    public <O extends Record> OrderLineItem(Table<O> child, ForeignKey<O, OrderLineItemRecord> key) {
        super(child, key, ORDER_LINE_ITEM);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<OrderLineItemRecord, ULong> getIdentity() {
        return (Identity<OrderLineItemRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<OrderLineItemRecord> getPrimaryKey() {
        return Keys.KEY_ORDER_LINE_ITEM_PRIMARY;
    }

    @Override
    public OrderLineItem as(String alias) {
        return new OrderLineItem(DSL.name(alias), this);
    }

    @Override
    public OrderLineItem as(Name alias) {
        return new OrderLineItem(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderLineItem rename(String name) {
        return new OrderLineItem(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderLineItem rename(Name name) {
        return new OrderLineItem(name, null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<ULong, ULong, ULong, String, BigDecimal, Integer, BigDecimal, BigDecimal, BigDecimal, UByte, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}
