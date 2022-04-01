/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables;


import com.bcorp.polaris.core.model.Keys;
import com.bcorp.polaris.core.model.PolarisDb;
import com.bcorp.polaris.core.model.tables.records.OrderRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UByte;
import org.jooq.types.ULong;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Order extends TableImpl<OrderRecord>
{

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.order</code>
     */
    public static final Order ORDER = new Order();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderRecord> getRecordType()
    {
        return OrderRecord.class;
    }

    /**
     * The column <code>polaris-db.order.id</code>.
     */
    public final TableField<OrderRecord, ULong> ID = createField(DSL.name("id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.order.user_id</code>. 購買人 id
     */
    public final TableField<OrderRecord, ULong> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "購買人 id");

    /**
     * The column <code>polaris-db.order.invoice_id</code>. 發票 id
     */
    public final TableField<OrderRecord, ULong> INVOICE_ID = createField(DSL.name("invoice_id"), SQLDataType.BIGINTUNSIGNED, this, "發票 id");

    /**
     * The column <code>polaris-db.order.code</code>. 訂單編號
     */
    public final TableField<OrderRecord, String> CODE = createField(DSL.name("code"), SQLDataType.VARCHAR(255).nullable(false), this, "訂單編號");

    /**
     * The column <code>polaris-db.order.order_status</code>. 訂單狀態
     */
    public final TableField<OrderRecord, UByte> ORDER_STATUS = createField(DSL.name("order_status"), SQLDataType.TINYINTUNSIGNED.nullable(false), this, "訂單狀態");

    /**
     * The column <code>polaris-db.order.subtotal</code>. 訂單小計
     */
    public final TableField<OrderRecord, BigDecimal> SUBTOTAL = createField(DSL.name("subtotal"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "訂單小計");

    /**
     * The column <code>polaris-db.order.total_discounts</code>. 訂單總折扣
     */
    public final TableField<OrderRecord, BigDecimal> TOTAL_DISCOUNTS = createField(DSL.name("total_discounts"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "訂單總折扣");

    /**
     * The column <code>polaris-db.order.total_price</code>. 訂單總金額
     */
    public final TableField<OrderRecord, BigDecimal> TOTAL_PRICE = createField(DSL.name("total_price"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "訂單總金額");

    /**
     * The column <code>polaris-db.order.payment_mode_id</code>. 付款方式
     */
    public final TableField<OrderRecord, ULong> PAYMENT_MODE_ID = createField(DSL.name("payment_mode_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "付款方式");

    /**
     * The column <code>polaris-db.order.payment_status</code>. 付款狀態
     */
    public final TableField<OrderRecord, UByte> PAYMENT_STATUS = createField(DSL.name("payment_status"), SQLDataType.TINYINTUNSIGNED.nullable(false), this, "付款狀態");

    /**
     * The column <code>polaris-db.order.pay_at</code>. 付款時間
     */
    public final TableField<OrderRecord, LocalDateTime> PAY_AT = createField(DSL.name("pay_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "付款時間");

    /**
     * The column <code>polaris-db.order.complete_at</code>. 訂單完成時間
     */
    public final TableField<OrderRecord, LocalDateTime> COMPLETE_AT = createField(DSL.name("complete_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "訂單完成時間");

    /**
     * The column <code>polaris-db.order.is_deleted</code>. 訂單禁止刪除
     */
    public final TableField<OrderRecord, UByte> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "訂單禁止刪除");

    /**
     * The column <code>polaris-db.order.created_at</code>. 建立時間
     */
    public final TableField<OrderRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.order.updated_at</code>. 修改時間
     */
    public final TableField<OrderRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private Order(Name alias, Table<OrderRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Order(Name alias, Table<OrderRecord> aliased, Field<?>[] parameters)
    {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.order</code> table reference
     */
    public Order(String alias)
    {
        this(DSL.name(alias), ORDER);
    }

    /**
     * Create an aliased <code>polaris-db.order</code> table reference
     */
    public Order(Name alias)
    {
        this(alias, ORDER);
    }

    /**
     * Create a <code>polaris-db.order</code> table reference
     */
    public Order()
    {
        this(DSL.name("order"), null);
    }

    public <O extends Record> Order(Table<O> child, ForeignKey<O, OrderRecord> key)
    {
        super(child, key, ORDER);
    }

    @Override
    public Schema getSchema()
    {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<OrderRecord, ULong> getIdentity()
    {
        return (Identity<OrderRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<OrderRecord> getPrimaryKey()
    {
        return Keys.KEY_ORDER_PRIMARY;
    }

    @Override
    public List<UniqueKey<OrderRecord>> getUniqueKeys()
    {
        return Arrays.asList(Keys.KEY_ORDER_UK_ORDER_CODE);
    }

    @Override
    public Order as(String alias)
    {
        return new Order(DSL.name(alias), this);
    }

    @Override
    public Order as(Name alias)
    {
        return new Order(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Order rename(String name)
    {
        return new Order(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Order rename(Name name)
    {
        return new Order(name, null);
    }

    // -------------------------------------------------------------------------
    // Row15 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row15<ULong, ULong, ULong, String, UByte, BigDecimal, BigDecimal, BigDecimal, ULong, UByte, LocalDateTime, LocalDateTime, UByte, LocalDateTime, LocalDateTime> fieldsRow()
    {
        return (Row15) super.fieldsRow();
    }
}
