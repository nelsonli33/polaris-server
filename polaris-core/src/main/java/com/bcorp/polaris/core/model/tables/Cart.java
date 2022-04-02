/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables;


import com.bcorp.polaris.core.model.Keys;
import com.bcorp.polaris.core.model.PolarisDb;
import com.bcorp.polaris.core.model.tables.records.CartRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Cart extends TableImpl<CartRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.cart</code>
     */
    public static final Cart CART = new Cart();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CartRecord> getRecordType() {
        return CartRecord.class;
    }

    /**
     * The column <code>polaris-db.cart.id</code>.
     */
    public final TableField<CartRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.cart.code</code>. 購物車編號
     */
    public final TableField<CartRecord, String> CODE = createField(DSL.name("code"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "購物車編號");

    /**
     * The column <code>polaris-db.cart.subtotal</code>. 購物車小計
     */
    public final TableField<CartRecord, BigDecimal> SUBTOTAL = createField(DSL.name("subtotal"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "購物車小計");

    /**
     * The column <code>polaris-db.cart.total_price</code>. 購物車總金額
     */
    public final TableField<CartRecord, BigDecimal> TOTAL_PRICE = createField(DSL.name("total_price"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "購物車總金額");

    /**
     * The column <code>polaris-db.cart.total_discounts</code>. 購物車總折扣
     */
    public final TableField<CartRecord, BigDecimal> TOTAL_DISCOUNTS = createField(DSL.name("total_discounts"), SQLDataType.DECIMAL(10, 2).nullable(false).defaultValue(DSL.inline("0.00", SQLDataType.DECIMAL)), this, "購物車總折扣");

    /**
     * The column <code>polaris-db.cart.user_id</code>. 使用者 id
     */
    public final TableField<CartRecord, Long> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINT.nullable(false), this, "使用者 id");

    /**
     * The column <code>polaris-db.cart.created_at</code>. 建立時間
     */
    public final TableField<CartRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.cart.updated_at</code>. 修改時間
     */
    public final TableField<CartRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private Cart(Name alias, Table<CartRecord> aliased) {
        this(alias, aliased, null);
    }

    private Cart(Name alias, Table<CartRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.cart</code> table reference
     */
    public Cart(String alias) {
        this(DSL.name(alias), CART);
    }

    /**
     * Create an aliased <code>polaris-db.cart</code> table reference
     */
    public Cart(Name alias) {
        this(alias, CART);
    }

    /**
     * Create a <code>polaris-db.cart</code> table reference
     */
    public Cart() {
        this(DSL.name("cart"), null);
    }

    public <O extends Record> Cart(Table<O> child, ForeignKey<O, CartRecord> key) {
        super(child, key, CART);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<CartRecord, Long> getIdentity() {
        return (Identity<CartRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<CartRecord> getPrimaryKey() {
        return Keys.KEY_CART_PRIMARY;
    }

    @Override
    public List<UniqueKey<CartRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_CART_UK_CART_CODE);
    }

    @Override
    public Cart as(String alias) {
        return new Cart(DSL.name(alias), this);
    }

    @Override
    public Cart as(Name alias) {
        return new Cart(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Cart rename(String name) {
        return new Cart(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Cart rename(Name name) {
        return new Cart(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Long, String, BigDecimal, BigDecimal, BigDecimal, Long, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
