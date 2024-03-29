/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables.records;


import com.bcorp.polaris.core.model.tables.UserBookshelf;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserBookshelfRecord extends UpdatableRecordImpl<UserBookshelfRecord> implements Record7<Long, Long, Long, Long, Byte, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>polaris-db.user_bookshelf.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>polaris-db.user_bookshelf.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>polaris-db.user_bookshelf.user_id</code>. 使用者 id
     */
    public void setUserId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>polaris-db.user_bookshelf.user_id</code>. 使用者 id
     */
    public Long getUserId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>polaris-db.user_bookshelf.book_id</code>. 書本 id
     */
    public void setBookId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>polaris-db.user_bookshelf.book_id</code>. 書本 id
     */
    public Long getBookId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>polaris-db.user_bookshelf.last_page_id</code>. 上次閱讀 page
     * id
     */
    public void setLastPageId(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>polaris-db.user_bookshelf.last_page_id</code>. 上次閱讀 page
     * id
     */
    public Long getLastPageId() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>polaris-db.user_bookshelf.is_deleted</code>.
     * 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public void setIsDeleted(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>polaris-db.user_bookshelf.is_deleted</code>.
     * 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public Byte getIsDeleted() {
        return (Byte) get(4);
    }

    /**
     * Setter for <code>polaris-db.user_bookshelf.created_at</code>. 建立時間
     */
    public void setCreatedAt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>polaris-db.user_bookshelf.created_at</code>. 建立時間
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>polaris-db.user_bookshelf.updated_at</code>. 修改時間
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(6, value);
    }

    /**
     * Getter for <code>polaris-db.user_bookshelf.updated_at</code>. 修改時間
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<Long, Long, Long, Long, Byte, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<Long, Long, Long, Long, Byte, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return UserBookshelf.USER_BOOKSHELF.ID;
    }

    @Override
    public Field<Long> field2() {
        return UserBookshelf.USER_BOOKSHELF.USER_ID;
    }

    @Override
    public Field<Long> field3() {
        return UserBookshelf.USER_BOOKSHELF.BOOK_ID;
    }

    @Override
    public Field<Long> field4() {
        return UserBookshelf.USER_BOOKSHELF.LAST_PAGE_ID;
    }

    @Override
    public Field<Byte> field5() {
        return UserBookshelf.USER_BOOKSHELF.IS_DELETED;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return UserBookshelf.USER_BOOKSHELF.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return UserBookshelf.USER_BOOKSHELF.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getId();
    }

    @Override
    public Long component2() {
        return getUserId();
    }

    @Override
    public Long component3() {
        return getBookId();
    }

    @Override
    public Long component4() {
        return getLastPageId();
    }

    @Override
    public Byte component5() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component7() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getId();
    }

    @Override
    public Long value2() {
        return getUserId();
    }

    @Override
    public Long value3() {
        return getBookId();
    }

    @Override
    public Long value4() {
        return getLastPageId();
    }

    @Override
    public Byte value5() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value7() {
        return getUpdatedAt();
    }

    @Override
    public UserBookshelfRecord value1(Long value) {
        setId(value);
        return this;
    }

    @Override
    public UserBookshelfRecord value2(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserBookshelfRecord value3(Long value) {
        setBookId(value);
        return this;
    }

    @Override
    public UserBookshelfRecord value4(Long value) {
        setLastPageId(value);
        return this;
    }

    @Override
    public UserBookshelfRecord value5(Byte value) {
        setIsDeleted(value);
        return this;
    }

    @Override
    public UserBookshelfRecord value6(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UserBookshelfRecord value7(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public UserBookshelfRecord values(Long value1, Long value2, Long value3, Long value4, Byte value5, LocalDateTime value6, LocalDateTime value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserBookshelfRecord
     */
    public UserBookshelfRecord() {
        super(UserBookshelf.USER_BOOKSHELF);
    }

    /**
     * Create a detached, initialised UserBookshelfRecord
     */
    public UserBookshelfRecord(Long id, Long userId, Long bookId, Long lastPageId, Byte isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(UserBookshelf.USER_BOOKSHELF);

        setId(id);
        setUserId(userId);
        setBookId(bookId);
        setLastPageId(lastPageId);
        setIsDeleted(isDeleted);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }
}
