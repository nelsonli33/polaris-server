/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class CartLineItem implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long cartId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;
    private BigDecimal totalDiscounts;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CartLineItem()
    {
    }

    public CartLineItem(CartLineItem value)
    {
        this.id = value.id;
        this.cartId = value.cartId;
        this.name = value.name;
        this.price = value.price;
        this.quantity = value.quantity;
        this.subtotal = value.subtotal;
        this.totalDiscounts = value.totalDiscounts;
        this.totalPrice = value.totalPrice;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public CartLineItem(
            Long id,
            Long cartId,
            String name,
            BigDecimal price,
            Integer quantity,
            BigDecimal subtotal,
            BigDecimal totalDiscounts,
            BigDecimal totalPrice,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    )
    {
        this.id = id;
        this.cartId = cartId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.totalDiscounts = totalDiscounts;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.id</code>.
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.id</code>.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.cart_id</code>. 購物車 id
     */
    public Long getCartId()
    {
        return this.cartId;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.cart_id</code>. 購物車 id
     */
    public void setCartId(Long cartId)
    {
        this.cartId = cartId;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.name</code>. 商品名稱
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.name</code>. 商品名稱
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.price</code>. 商品金額
     */
    public BigDecimal getPrice()
    {
        return this.price;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.price</code>. 商品金額
     */
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.quantity</code>.
     */
    public Integer getQuantity()
    {
        return this.quantity;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.quantity</code>.
     */
    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.subtotal</code>. 商品小計
     */
    public BigDecimal getSubtotal()
    {
        return this.subtotal;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.subtotal</code>. 商品小計
     */
    public void setSubtotal(BigDecimal subtotal)
    {
        this.subtotal = subtotal;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.total_discounts</code>. 商品總折扣
     */
    public BigDecimal getTotalDiscounts()
    {
        return this.totalDiscounts;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.total_discounts</code>. 商品總折扣
     */
    public void setTotalDiscounts(BigDecimal totalDiscounts)
    {
        this.totalDiscounts = totalDiscounts;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.total_price</code>. 商品總金額
     */
    public BigDecimal getTotalPrice()
    {
        return this.totalPrice;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.total_price</code>. 商品總金額
     */
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.created_at</code>. 建立時間
     */
    public LocalDateTime getCreatedAt()
    {
        return this.createdAt;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.created_at</code>. 建立時間
     */
    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    /**
     * Getter for <code>polaris-db.cart_line_item.updated_at</code>. 修改時間
     */
    public LocalDateTime getUpdatedAt()
    {
        return this.updatedAt;
    }

    /**
     * Setter for <code>polaris-db.cart_line_item.updated_at</code>. 修改時間
     */
    public void setUpdatedAt(LocalDateTime updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("CartLineItem (");

        sb.append(id);
        sb.append(", ").append(cartId);
        sb.append(", ").append(name);
        sb.append(", ").append(price);
        sb.append(", ").append(quantity);
        sb.append(", ").append(subtotal);
        sb.append(", ").append(totalDiscounts);
        sb.append(", ").append(totalPrice);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}