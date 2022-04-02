/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.author.dto;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Page implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long chapterId;
    private String title;
    private String body;
    private Integer characterCount;
    private Integer sortPosition;
    private Byte isDeleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Page()
    {
    }

    public Page(Page value)
    {
        this.id = value.id;
        this.chapterId = value.chapterId;
        this.title = value.title;
        this.body = value.body;
        this.characterCount = value.characterCount;
        this.sortPosition = value.sortPosition;
        this.isDeleted = value.isDeleted;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public Page(
            Long id,
            Long chapterId,
            String title,
            String body,
            Integer characterCount,
            Integer sortPosition,
            Byte isDeleted,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    )
    {
        this.id = id;
        this.chapterId = chapterId;
        this.title = title;
        this.body = body;
        this.characterCount = characterCount;
        this.sortPosition = sortPosition;
        this.isDeleted = isDeleted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for <code>polaris-db.page.id</code>.
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * Setter for <code>polaris-db.page.id</code>.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * Getter for <code>polaris-db.page.chapter_id</code>. 章節 id
     */
    public Long getChapterId()
    {
        return this.chapterId;
    }

    /**
     * Setter for <code>polaris-db.page.chapter_id</code>. 章節 id
     */
    public void setChapterId(Long chapterId)
    {
        this.chapterId = chapterId;
    }

    /**
     * Getter for <code>polaris-db.page.title</code>. 頁面標題
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Setter for <code>polaris-db.page.title</code>. 頁面標題
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Getter for <code>polaris-db.page.body</code>. 頁面內容
     */
    public String getBody()
    {
        return this.body;
    }

    /**
     * Setter for <code>polaris-db.page.body</code>. 頁面內容
     */
    public void setBody(String body)
    {
        this.body = body;
    }

    /**
     * Getter for <code>polaris-db.page.character_count</code>. 字數
     */
    public Integer getCharacterCount()
    {
        return this.characterCount;
    }

    /**
     * Setter for <code>polaris-db.page.character_count</code>. 字數
     */
    public void setCharacterCount(Integer characterCount)
    {
        this.characterCount = characterCount;
    }

    /**
     * Getter for <code>polaris-db.page.sort_position</code>. 排序位置
     */
    public Integer getSortPosition()
    {
        return this.sortPosition;
    }

    /**
     * Setter for <code>polaris-db.page.sort_position</code>. 排序位置
     */
    public void setSortPosition(Integer sortPosition)
    {
        this.sortPosition = sortPosition;
    }

    /**
     * Getter for <code>polaris-db.page.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public Byte getIsDeleted()
    {
        return this.isDeleted;
    }

    /**
     * Setter for <code>polaris-db.page.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public void setIsDeleted(Byte isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    /**
     * Getter for <code>polaris-db.page.created_at</code>. 建立時間
     */
    public LocalDateTime getCreatedAt()
    {
        return this.createdAt;
    }

    /**
     * Setter for <code>polaris-db.page.created_at</code>. 建立時間
     */
    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    /**
     * Getter for <code>polaris-db.page.updated_at</code>. 修改時間
     */
    public LocalDateTime getUpdatedAt()
    {
        return this.updatedAt;
    }

    /**
     * Setter for <code>polaris-db.page.updated_at</code>. 修改時間
     */
    public void setUpdatedAt(LocalDateTime updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Page (");

        sb.append(id);
        sb.append(", ").append(chapterId);
        sb.append(", ").append(title);
        sb.append(", ").append(body);
        sb.append(", ").append(characterCount);
        sb.append(", ").append(sortPosition);
        sb.append(", ").append(isDeleted);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
