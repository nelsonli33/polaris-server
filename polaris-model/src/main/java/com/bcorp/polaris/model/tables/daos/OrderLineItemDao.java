/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.model.tables.daos;


import com.bcorp.polaris.model.tables.OrderLineItem;
import com.bcorp.polaris.model.tables.records.OrderLineItemRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.jooq.types.UByte;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class OrderLineItemDao extends DAOImpl<OrderLineItemRecord, com.bcorp.polaris.model.tables.pojos.OrderLineItem, ULong> {

    /**
     * Create a new OrderLineItemDao without any configuration
     */
    public OrderLineItemDao() {
        super(OrderLineItem.ORDER_LINE_ITEM, com.bcorp.polaris.model.tables.pojos.OrderLineItem.class);
    }

    /**
     * Create a new OrderLineItemDao with an attached configuration
     */
    @Autowired
    public OrderLineItemDao(Configuration configuration) {
        super(OrderLineItem.ORDER_LINE_ITEM, com.bcorp.polaris.model.tables.pojos.OrderLineItem.class, configuration);
    }

    @Override
    public ULong getId(com.bcorp.polaris.model.tables.pojos.OrderLineItem object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfId(ULong lowerInclusive, ULong upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchById(ULong... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.bcorp.polaris.model.tables.pojos.OrderLineItem fetchOneById(ULong value) {
        return fetchOne(OrderLineItem.ORDER_LINE_ITEM.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchOptionalById(ULong value) {
        return fetchOptional(OrderLineItem.ORDER_LINE_ITEM.ID, value);
    }

    /**
     * Fetch records that have <code>order_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfOrderId(ULong lowerInclusive, ULong upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.ORDER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>order_id IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByOrderId(ULong... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.ORDER_ID, values);
    }

    /**
     * Fetch records that have <code>book_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfBookId(ULong lowerInclusive, ULong upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.BOOK_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>book_id IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByBookId(ULong... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.BOOK_ID, values);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByName(String... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.NAME, values);
    }

    /**
     * Fetch records that have <code>price BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfPrice(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByPrice(BigDecimal... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.PRICE, values);
    }

    /**
     * Fetch records that have <code>quantity BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfQuantity(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.QUANTITY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>quantity IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByQuantity(Integer... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.QUANTITY, values);
    }

    /**
     * Fetch records that have <code>subtotal BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfSubtotal(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.SUBTOTAL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>subtotal IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchBySubtotal(BigDecimal... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.SUBTOTAL, values);
    }

    /**
     * Fetch records that have <code>total_discounts BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfTotalDiscounts(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.TOTAL_DISCOUNTS, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>total_discounts IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByTotalDiscounts(BigDecimal... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.TOTAL_DISCOUNTS, values);
    }

    /**
     * Fetch records that have <code>total_price BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfTotalPrice(BigDecimal lowerInclusive, BigDecimal upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.TOTAL_PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>total_price IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByTotalPrice(BigDecimal... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.TOTAL_PRICE, values);
    }

    /**
     * Fetch records that have <code>is_deleted BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfIsDeleted(UByte lowerInclusive, UByte upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.IS_DELETED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_deleted IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByIsDeleted(UByte... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.IS_DELETED, values);
    }

    /**
     * Fetch records that have <code>created_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfCreatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.CREATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>created_at IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByCreatedAt(LocalDateTime... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.CREATED_AT, values);
    }

    /**
     * Fetch records that have <code>updated_at BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchRangeOfUpdatedAt(LocalDateTime lowerInclusive, LocalDateTime upperInclusive) {
        return fetchRange(OrderLineItem.ORDER_LINE_ITEM.UPDATED_AT, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>updated_at IN (values)</code>
     */
    public List<com.bcorp.polaris.model.tables.pojos.OrderLineItem> fetchByUpdatedAt(LocalDateTime... values) {
        return fetch(OrderLineItem.ORDER_LINE_ITEM.UPDATED_AT, values);
    }
}
