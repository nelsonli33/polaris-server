/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables;


import com.bcorp.polaris.core.model.Keys;
import com.bcorp.polaris.core.model.PolarisDb;
import com.bcorp.polaris.core.model.tables.records.PageRecord;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
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
public class Page extends TableImpl<PageRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.page</code>
     */
    public static final Page PAGE = new Page();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PageRecord> getRecordType() {
        return PageRecord.class;
    }

    /**
     * The column <code>polaris-db.page.id</code>.
     */
    public final TableField<PageRecord, Long> ID = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.page.chapter_id</code>. 章節 id
     */
    public final TableField<PageRecord, Long> CHAPTER_ID = createField(DSL.name("chapter_id"), SQLDataType.BIGINT.nullable(false), this, "章節 id");

    /**
     * The column <code>polaris-db.page.title</code>. 頁面標題
     */
    public final TableField<PageRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "頁面標題");

    /**
     * The column <code>polaris-db.page.body</code>. 頁面內容
     */
    public final TableField<PageRecord, String> BODY = createField(DSL.name("body"), SQLDataType.CLOB, this, "頁面內容");

    /**
     * The column <code>polaris-db.page.character_count</code>. 字數
     */
    public final TableField<PageRecord, Integer> CHARACTER_COUNT = createField(DSL.name("character_count"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "字數");

    /**
     * The column <code>polaris-db.page.sort_position</code>. 排序位置
     */
    public final TableField<PageRecord, Integer> SORT_POSITION = createField(DSL.name("sort_position"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "排序位置");

    /**
     * The column <code>polaris-db.page.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public final TableField<PageRecord, Byte> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.TINYINT.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINT)), this, "是否刪除，0-未刪除，1-刪除，預設為 0");

    /**
     * The column <code>polaris-db.page.created_at</code>. 建立時間
     */
    public final TableField<PageRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.page.updated_at</code>. 修改時間
     */
    public final TableField<PageRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private Page(Name alias, Table<PageRecord> aliased) {
        this(alias, aliased, null);
    }

    private Page(Name alias, Table<PageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.page</code> table reference
     */
    public Page(String alias) {
        this(DSL.name(alias), PAGE);
    }

    /**
     * Create an aliased <code>polaris-db.page</code> table reference
     */
    public Page(Name alias) {
        this(alias, PAGE);
    }

    /**
     * Create a <code>polaris-db.page</code> table reference
     */
    public Page() {
        this(DSL.name("page"), null);
    }

    public <O extends Record> Page(Table<O> child, ForeignKey<O, PageRecord> key) {
        super(child, key, PAGE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<PageRecord, Long> getIdentity() {
        return (Identity<PageRecord, Long>) super.getIdentity();
    }

    @Override
    public UniqueKey<PageRecord> getPrimaryKey() {
        return Keys.KEY_PAGE_PRIMARY;
    }

    @Override
    public Page as(String alias) {
        return new Page(DSL.name(alias), this);
    }

    @Override
    public Page as(Name alias) {
        return new Page(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Page rename(String name) {
        return new Page(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Page rename(Name name) {
        return new Page(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, Long, String, String, Integer, Integer, Byte, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
