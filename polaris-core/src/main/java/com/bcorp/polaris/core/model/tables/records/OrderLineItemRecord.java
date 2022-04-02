/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables.records;


import com.bcorp.polaris.core.model.tables.OrderLineItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderLineItemRecord extends UpdatableRecordImpl<OrderLineItemRecord> implements Record12<Long, Long, Long, String, BigDecimal, Integer, BigDecimal, BigDecimal, BigDecimal, Byte, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>polaris-db.order_line_item.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.order_id</code>.
     */
    public void setOrderId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.order_id</code>.
     */
    public Long getOrderId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.book_id</code>.
     */
    public void setBookId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.book_id</code>.
     */
    public Long getBookId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.name</code>. 商品名稱
     */
    public void setName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.name</code>. 商品名稱
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.price</code>. 商品金額
     */
    public void setPrice(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.price</code>. 商品金額
     */
    public BigDecimal getPrice() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.quantity</code>.
     */
    public void setQuantity(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.subtotal</code>. 商品小計
     */
    public void setSubtotal(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.subtotal</code>. 商品小計
     */
    public BigDecimal getSubtotal() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.total_discounts</code>. 商品總折扣
     */
    public void setTotalDiscounts(BigDecimal value) {
        set(7, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.total_discounts</code>. 商品總折扣
     */
    public BigDecimal getTotalDiscounts() {
        return (BigDecimal) get(7);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.total_price</code>. 商品總金額
     */
    public void setTotalPrice(BigDecimal value) {
        set(8, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.total_price</code>. 商品總金額
     */
    public BigDecimal getTotalPrice() {
        return (BigDecimal) get(8);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.is_deleted</code>. 訂單商品禁止刪除
     */
    public void setIsDeleted(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.is_deleted</code>. 訂單商品禁止刪除
     */
    public Byte getIsDeleted() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.created_at</code>. 建立時間
     */
    public void setCreatedAt(LocalDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.created_at</code>. 建立時間
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(10);
    }

    /**
     * Setter for <code>polaris-db.order_line_item.updated_at</code>. 修改時間
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(11, value);
    }

    /**
     * Getter for <code>polaris-db.order_line_item.updated_at</code>. 修改時間
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row12<Long, Long, Long, String, BigDecimal, Integer, BigDecimal, BigDecimal, BigDecimal, Byte, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<Long, Long, Long, String, BigDecimal, Integer, BigDecimal, BigDecimal, BigDecimal, Byte, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return OrderLineItem.ORDER_LINE_ITEM.ID;
    }

    @Override
    public Field<Long> field2() {
        return OrderLineItem.ORDER_LINE_ITEM.ORDER_ID;
    }

    @Override
    public Field<Long> field3() {
        return OrderLineItem.ORDER_LINE_ITEM.BOOK_ID;
    }

    @Override
    public Field<String> field4() {
        return OrderLineItem.ORDER_LINE_ITEM.NAME;
    }

    @Override
    public Field<BigDecimal> field5() {
        return OrderLineItem.ORDER_LINE_ITEM.PRICE;
    }

    @Override
    public Field<Integer> field6() {
        return OrderLineItem.ORDER_LINE_ITEM.QUANTITY;
    }

    @Override
    public Field<BigDecimal> field7() {
        return OrderLineItem.ORDER_LINE_ITEM.SUBTOTAL;
    }

    @Override
    public Field<BigDecimal> field8() {
        return OrderLineItem.ORDER_LINE_ITEM.TOTAL_DISCOUNTS;
    }

    @Override
    public Field<BigDecimal> field9() {
        return OrderLineItem.ORDER_LINE_ITEM.TOTAL_PRICE;
    }

    @Override
    public Field<Byte> field10() {
        return OrderLineItem.ORDER_LINE_ITEM.IS_DELETED;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return OrderLineItem.ORDER_LINE_ITEM.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field12() {
        return OrderLineItem.ORDER_LINE_ITEM.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getOrderId();
    }

    @Override
    public Long component3() {
        return getBookId();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public BigDecimal component5() {
        return getPrice();
    }

    @Override
    public Integer component6() {
        return getQuantity();
    }

    @Override
    public BigDecimal component7() {
        return getSubtotal();
    }

    @Override
    public BigDecimal component8() {
        return getTotalDiscounts();
    }

    @Override
    public BigDecimal component9() {
        return getTotalPrice();
    }

    @Override
    public Byte component10() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime component11() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component12() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getOrderId();
    }

    @Override
    public Long value3() {
        return getBookId();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public BigDecimal value5() {
        return getPrice();
    }

    @Override
    public Integer value6() {
        return getQuantity();
    }

    @Override
    public BigDecimal value7() {
        return getSubtotal();
    }

    @Override
    public BigDecimal value8() {
        return getTotalDiscounts();
    }

    @Override
    public BigDecimal value9() {
        return getTotalPrice();
    }

    @Override
    public Byte value10() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime value11() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value12() {
        return getUpdatedAt();
    }

    @Override
    public OrderLineItemRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value2(Long value) {
        setOrderId(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value3(Long value) {
        setBookId(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value5(BigDecimal value) {
        setPrice(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value6(Integer value) {
        setQuantity(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value7(BigDecimal value) {
        setSubtotal(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value8(BigDecimal value) {
        setTotalDiscounts(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value9(BigDecimal value) {
        setTotalPrice(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value10(Byte value) {
        setIsDeleted(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value11(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public OrderLineItemRecord value12(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public OrderLineItemRecord values(Long value1, Long value2, Long value3, String value4, BigDecimal value5, Integer value6, BigDecimal value7, BigDecimal value8, BigDecimal value9, Byte value10, LocalDateTime value11, LocalDateTime value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderLineItemRecord
     */
    public OrderLineItemRecord() {
        super(OrderLineItem.ORDER_LINE_ITEM);
    }

    /**
     * Create a detached, initialised OrderLineItemRecord
     */
    public OrderLineItemRecord(Long id, Long orderId, Long bookId, String name, BigDecimal price, Integer quantity, BigDecimal subtotal, BigDecimal totalDiscounts, BigDecimal totalPrice, Byte isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(OrderLineItem.ORDER_LINE_ITEM);

        setId(id);
        setOrderId(orderId);
        setBookId(bookId);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setSubtotal(subtotal);
        setTotalDiscounts(totalDiscounts);
        setTotalPrice(totalPrice);
        setIsDeleted(isDeleted);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }
}
