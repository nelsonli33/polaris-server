/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables;


import com.bcorp.polaris.core.model.Keys;
import com.bcorp.polaris.core.model.PolarisDb;
import com.bcorp.polaris.core.model.tables.records.ChapterRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UByte;
import org.jooq.types.ULong;

import java.time.LocalDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Chapter extends TableImpl<ChapterRecord>
{

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.chapter</code>
     */
    public static final Chapter CHAPTER = new Chapter();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ChapterRecord> getRecordType()
    {
        return ChapterRecord.class;
    }

    /**
     * The column <code>polaris-db.chapter.id</code>.
     */
    public final TableField<ChapterRecord, ULong> ID = createField(DSL.name("id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.chapter.book_id</code>. 書本 id
     */
    public final TableField<ChapterRecord, ULong> BOOK_ID = createField(DSL.name("book_id"), SQLDataType.BIGINTUNSIGNED.nullable(false), this, "書本 id");

    /**
     * The column <code>polaris-db.chapter.title</code>. 章節名稱
     */
    public final TableField<ChapterRecord, String> TITLE = createField(DSL.name("title"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "章節名稱");

    /**
     * The column <code>polaris-db.chapter.sort_position</code>. 排序位置
     */
    public final TableField<ChapterRecord, Integer> SORT_POSITION = createField(DSL.name("sort_position"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "排序位置");

    /**
     * The column <code>polaris-db.chapter.is_deleted</code>.
     * 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public final TableField<ChapterRecord, UByte> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "是否刪除，0-未刪除，1-刪除，預設為 0");

    /**
     * The column <code>polaris-db.chapter.created_at</code>. 建立時間
     */
    public final TableField<ChapterRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.chapter.updated_at</code>. 修改時間
     */
    public final TableField<ChapterRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private Chapter(Name alias, Table<ChapterRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Chapter(Name alias, Table<ChapterRecord> aliased, Field<?>[] parameters)
    {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.chapter</code> table reference
     */
    public Chapter(String alias)
    {
        this(DSL.name(alias), CHAPTER);
    }

    /**
     * Create an aliased <code>polaris-db.chapter</code> table reference
     */
    public Chapter(Name alias)
    {
        this(alias, CHAPTER);
    }

    /**
     * Create a <code>polaris-db.chapter</code> table reference
     */
    public Chapter()
    {
        this(DSL.name("chapter"), null);
    }

    public <O extends Record> Chapter(Table<O> child, ForeignKey<O, ChapterRecord> key)
    {
        super(child, key, CHAPTER);
    }

    @Override
    public Schema getSchema()
    {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<ChapterRecord, ULong> getIdentity()
    {
        return (Identity<ChapterRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<ChapterRecord> getPrimaryKey()
    {
        return Keys.KEY_CHAPTER_PRIMARY;
    }

    @Override
    public Chapter as(String alias)
    {
        return new Chapter(DSL.name(alias), this);
    }

    @Override
    public Chapter as(Name alias)
    {
        return new Chapter(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Chapter rename(String name)
    {
        return new Chapter(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Chapter rename(Name name)
    {
        return new Chapter(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<ULong, ULong, String, Integer, UByte, LocalDateTime, LocalDateTime> fieldsRow()
    {
        return (Row7) super.fieldsRow();
    }
}
