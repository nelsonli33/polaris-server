/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.model.tables;


import com.bcorp.polaris.model.Keys;
import com.bcorp.polaris.model.PolarisDb;
import com.bcorp.polaris.model.tables.records.BookReviewRecord;

import java.time.LocalDateTime;

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
import org.jooq.types.UByte;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookReview extends TableImpl<BookReviewRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.book_review</code>
     */
    public static final BookReview BOOK_REVIEW = new BookReview();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BookReviewRecord> getRecordType() {
        return BookReviewRecord.class;
    }

    /**
     * The column <code>polaris-db.book_review.id</code>.
     */
    public final TableField<BookReviewRecord, ULong> ID = createField(DSL.name("id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.book_review.comment</code>. 留言內容
     */
    public final TableField<BookReviewRecord, String> COMMENT = createField(DSL.name("comment"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "留言內容");

    /**
     * The column <code>polaris-db.book_review.user_id</code>. 使用者 id
     */
    public final TableField<BookReviewRecord, ULong> USER_ID = createField(DSL.name("user_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "使用者 id");

    /**
     * The column <code>polaris-db.book_review.book_id</code>. 書本   id
     */
    public final TableField<BookReviewRecord, ULong> BOOK_ID = createField(DSL.name("book_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "書本   id");

    /**
     * The column <code>polaris-db.book_review.rating_star</code>. 評分 0 ~ 5
     */
    public final TableField<BookReviewRecord, UByte> RATING_STAR = createField(DSL.name("rating_star"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "評分 0 ~ 5");

    /**
     * The column <code>polaris-db.book_review.is_deleted</code>.
     * 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public final TableField<BookReviewRecord, UByte> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "是否刪除，0-未刪除，1-刪除，預設為 0");

    /**
     * The column <code>polaris-db.book_review.created_at</code>. 建立時間
     */
    public final TableField<BookReviewRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.book_review.updated_at</code>. 修改時間
     */
    public final TableField<BookReviewRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private BookReview(Name alias, Table<BookReviewRecord> aliased) {
        this(alias, aliased, null);
    }

    private BookReview(Name alias, Table<BookReviewRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.book_review</code> table reference
     */
    public BookReview(String alias) {
        this(DSL.name(alias), BOOK_REVIEW);
    }

    /**
     * Create an aliased <code>polaris-db.book_review</code> table reference
     */
    public BookReview(Name alias) {
        this(alias, BOOK_REVIEW);
    }

    /**
     * Create a <code>polaris-db.book_review</code> table reference
     */
    public BookReview() {
        this(DSL.name("book_review"), null);
    }

    public <O extends Record> BookReview(Table<O> child, ForeignKey<O, BookReviewRecord> key) {
        super(child, key, BOOK_REVIEW);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<BookReviewRecord, ULong> getIdentity() {
        return (Identity<BookReviewRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<BookReviewRecord> getPrimaryKey() {
        return Keys.KEY_BOOK_REVIEW_PRIMARY;
    }

    @Override
    public BookReview as(String alias) {
        return new BookReview(DSL.name(alias), this);
    }

    @Override
    public BookReview as(Name alias) {
        return new BookReview(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public BookReview rename(String name) {
        return new BookReview(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public BookReview rename(Name name) {
        return new BookReview(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<ULong, String, ULong, ULong, UByte, UByte, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}
