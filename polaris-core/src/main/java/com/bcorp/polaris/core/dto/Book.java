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
public class Book implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private Long bookCategoryId;
    private String title;
    private Byte priceType;
    private BigDecimal price;
    private String synopsis;
    private String acquisition;
    private String cover;
    private LocalDateTime publishedAt;
    private Byte status;
    private Integer characterCount;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Book()
    {
    }

    public Book(Book value)
    {
        this.id = value.id;
        this.userId = value.userId;
        this.bookCategoryId = value.bookCategoryId;
        this.title = value.title;
        this.priceType = value.priceType;
        this.price = value.price;
        this.synopsis = value.synopsis;
        this.acquisition = value.acquisition;
        this.cover = value.cover;
        this.publishedAt = value.publishedAt;
        this.status = value.status;
        this.characterCount = value.characterCount;
        this.isDeleted = value.isDeleted;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Book(
            Long id,
            Long userId,
            Long bookCategoryId,
            String title,
            Byte priceType,
            BigDecimal price,
            String synopsis,
            String acquisition,
            String cover,
            LocalDateTime publishedAt,
            Byte status,
            Integer characterCount,
            Byte isDeleted,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    )
    {
        this.id = id;
        this.userId = userId;
        this.bookCategoryId = bookCategoryId;
        this.title = title;
        this.priceType = priceType;
        this.price = price;
        this.synopsis = synopsis;
        this.acquisition = acquisition;
        this.cover = cover;
        this.publishedAt = publishedAt;
        this.status = status;
        this.characterCount = characterCount;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for <code>polaris-db.book.id</code>.
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * Setter for <code>polaris-db.book.id</code>.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Getter for <code>polaris-db.book.user_id</code>. 作者 id
     */
    public Long getUserId()
    {
        return this.userId;
    }

    /**
     * Setter for <code>polaris-db.book.user_id</code>. 作者 id
     */
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    /**
     * Getter for <code>polaris-db.book.book_category_id</code>. 書本分類 id
     */
    public Long getBookCategoryId()
    {
        return this.bookCategoryId;
    }

    /**
     * Setter for <code>polaris-db.book.book_category_id</code>. 書本分類 id
     */
    public void setBookCategoryId(Long bookCategoryId)
    {
        this.bookCategoryId = bookCategoryId;
    }

    /**
     * Getter for <code>polaris-db.book.title</code>. 書本標題
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Setter for <code>polaris-db.book.title</code>. 書本標題
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Getter for <code>polaris-db.book.price_type</code>. 免費or付費閱讀，1-免費,
     * 2-付費，預設為 2
     */
    public Byte getPriceType()
    {
        return this.priceType;
    }

    /**
     * Setter for <code>polaris-db.book.price_type</code>. 免費or付費閱讀，1-免費,
     * 2-付費，預設為 2
     */
    public void setPriceType(Byte priceType)
    {
        this.priceType = priceType;
    }

    /**
     * Getter for <code>polaris-db.book.price</code>. 書本售價
     */
    public BigDecimal getPrice()
    {
        return this.price;
    }

    /**
     * Setter for <code>polaris-db.book.price</code>. 書本售價
     */
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    /**
     * Getter for <code>polaris-db.book.synopsis</code>. 書本簡介
     */
    public String getSynopsis()
    {
        return this.synopsis;
    }

    /**
     * Setter for <code>polaris-db.book.synopsis</code>. 書本簡介
     */
    public void setSynopsis(String synopsis)
    {
        this.synopsis = synopsis;
    }

    /**
     * Getter for <code>polaris-db.book.acquisition</code>. 你能學到
     */
    public String getAcquisition()
    {
        return this.acquisition;
    }

    /**
     * Setter for <code>polaris-db.book.acquisition</code>. 你能學到
     */
    public void setAcquisition(String acquisition)
    {
        this.acquisition = acquisition;
    }

    /**
     * Getter for <code>polaris-db.book.cover</code>. 書封
     */
    public String getCover()
    {
        return this.cover;
    }

    /**
     * Setter for <code>polaris-db.book.cover</code>. 書封
     */
    public void setCover(String cover)
    {
        this.cover = cover;
    }

    /**
     * Getter for <code>polaris-db.book.published_at</code>. 出版日期
     */
    public LocalDateTime getPublishedAt()
    {
        return this.publishedAt;
    }

    /**
     * Setter for <code>polaris-db.book.published_at</code>. 出版日期
     */
    public void setPublishedAt(LocalDateTime publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    /**
     * Getter for <code>polaris-db.book.status</code>. 上架狀態，0-未上架，1-已上架，預設為 0
     */
    public Byte getStatus()
    {
        return this.status;
    }

    /**
     * Setter for <code>polaris-db.book.status</code>. 上架狀態，0-未上架，1-已上架，預設為 0
     */
    public void setStatus(Byte status)
    {
        this.status = status;
    }

    /**
     * Getter for <code>polaris-db.book.character_count</code>. 總字數
     */
    public Integer getCharacterCount()
    {
        return this.characterCount;
    }

    /**
     * Setter for <code>polaris-db.book.character_count</code>. 總字數
     */
    public void setCharacterCount(Integer characterCount)
    {
        this.characterCount = characterCount;
    }

    /**
     * Getter for <code>polaris-db.book.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public Byte getIsDeleted()
    {
        return this.isDeleted;
    }

    /**
     * Setter for <code>polaris-db.book.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public void setIsDeleted(Byte isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    /**
     * Getter for <code>polaris-db.book.created_at</code>. 建立時間
     */
    public LocalDateTime getCreatedAt()
    {
        return this.createdAt;
    }

    /**
     * Setter for <code>polaris-db.book.created_at</code>. 建立時間
     */
    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    /**
     * Getter for <code>polaris-db.book.updated_at</code>. 修改時間
     */
    public LocalDateTime getUpdatedAt()
    {
        return this.updatedAt;
    }

    /**
     * Setter for <code>polaris-db.book.updated_at</code>. 修改時間
     */
    public void setUpdatedAt(LocalDateTime updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Book (");

        sb.append(id);
        sb.append(", ").append(userId);
        sb.append(", ").append(bookCategoryId);
        sb.append(", ").append(title);
        sb.append(", ").append(priceType);
        sb.append(", ").append(price);
        sb.append(", ").append(synopsis);
        sb.append(", ").append(acquisition);
        sb.append(", ").append(cover);
        sb.append(", ").append(publishedAt);
        sb.append(", ").append(status);
        sb.append(", ").append(characterCount);
        sb.append(", ").append(isDeleted);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}