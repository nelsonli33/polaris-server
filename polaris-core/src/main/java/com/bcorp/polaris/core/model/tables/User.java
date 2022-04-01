/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables;


import com.bcorp.polaris.core.model.Keys;
import com.bcorp.polaris.core.model.PolarisDb;
import com.bcorp.polaris.core.model.tables.records.UserRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;
import org.jooq.types.UByte;
import org.jooq.types.ULong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class User extends TableImpl<UserRecord>
{

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>polaris-db.user</code>
     */
    public static final User USER = new User();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType()
    {
        return UserRecord.class;
    }

    /**
     * The column <code>polaris-db.user.id</code>.
     */
    public final TableField<UserRecord, ULong> ID = createField(DSL.name("id"), SQLDataType.BIGINTUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>polaris-db.user.name</code>. 使用者名稱
     */
    public final TableField<UserRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "使用者名稱");

    /**
     * The column <code>polaris-db.user.uid</code>. 使用者 Uid
     */
    public final TableField<UserRecord, String> UID = createField(DSL.name("uid"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "使用者 Uid");

    /**
     * The column <code>polaris-db.user.password</code>. 使用者密碼
     */
    public final TableField<UserRecord, String> PASSWORD = createField(DSL.name("password"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "使用者密碼");

    /**
     * The column <code>polaris-db.user.email</code>. 使用者 E-mail
     */
    public final TableField<UserRecord, String> EMAIL = createField(DSL.name("email"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "使用者 E-mail");

    /**
     * The column <code>polaris-db.user.avatar</code>. 使用者頭像
     */
    public final TableField<UserRecord, String> AVATAR = createField(DSL.name("avatar"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "使用者頭像");

    /**
     * The column <code>polaris-db.user.short_bio</code>. 使用者簡短介紹
     */
    public final TableField<UserRecord, String> SHORT_BIO = createField(DSL.name("short_bio"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "使用者簡短介紹");

    /**
     * The column <code>polaris-db.user.full_bio</code>. 使用者完整介紹
     */
    public final TableField<UserRecord, String> FULL_BIO = createField(DSL.name("full_bio"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "使用者完整介紹");

    /**
     * The column <code>polaris-db.user.birthday</code>. 使用者生日
     */
    public final TableField<UserRecord, LocalDate> BIRTHDAY = createField(DSL.name("birthday"), SQLDataType.LOCALDATE, this, "使用者生日");

    /**
     * The column <code>polaris-db.user.is_author</code>. 是否是作者，0-否，1-是，預設為 0
     */
    public final TableField<UserRecord, UByte> IS_AUTHOR = createField(DSL.name("is_author"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "是否是作者，0-否，1-是，預設為 0");

    /**
     * The column <code>polaris-db.user.twitter</code>.
     */
    public final TableField<UserRecord, String> TWITTER = createField(DSL.name("twitter"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>polaris-db.user.github</code>.
     */
    public final TableField<UserRecord, String> GITHUB = createField(DSL.name("github"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>polaris-db.user.linkedin</code>.
     */
    public final TableField<UserRecord, String> LINKEDIN = createField(DSL.name("linkedin"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>polaris-db.user.facebook</code>.
     */
    public final TableField<UserRecord, String> FACEBOOK = createField(DSL.name("facebook"), SQLDataType.VARCHAR(255).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>polaris-db.user.is_blocked</code>. 是否停權，0-否，1-是，預設為 0
     */
    public final TableField<UserRecord, UByte> IS_BLOCKED = createField(DSL.name("is_blocked"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "是否停權，0-否，1-是，預設為 0");

    /**
     * The column <code>polaris-db.user.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public final TableField<UserRecord, UByte> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.TINYINTUNSIGNED.nullable(false).defaultValue(DSL.inline("0", SQLDataType.TINYINTUNSIGNED)), this, "是否刪除，0-未刪除，1-刪除，預設為 0");

    /**
     * The column <code>polaris-db.user.created_at</code>. 建立時間
     */
    public final TableField<UserRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "建立時間");

    /**
     * The column <code>polaris-db.user.updated_at</code>. 修改時間
     */
    public final TableField<UserRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(0).nullable(false), this, "修改時間");

    private User(Name alias, Table<UserRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private User(Name alias, Table<UserRecord> aliased, Field<?>[] parameters)
    {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>polaris-db.user</code> table reference
     */
    public User(String alias)
    {
        this(DSL.name(alias), USER);
    }

    /**
     * Create an aliased <code>polaris-db.user</code> table reference
     */
    public User(Name alias)
    {
        this(alias, USER);
    }

    /**
     * Create a <code>polaris-db.user</code> table reference
     */
    public User()
    {
        this(DSL.name("user"), null);
    }

    public <O extends Record> User(Table<O> child, ForeignKey<O, UserRecord> key)
    {
        super(child, key, USER);
    }

    @Override
    public Schema getSchema()
    {
        return aliased() ? null : PolarisDb.POLARIS_DB;
    }

    @Override
    public Identity<UserRecord, ULong> getIdentity()
    {
        return (Identity<UserRecord, ULong>) super.getIdentity();
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey()
    {
        return Keys.KEY_USER_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserRecord>> getUniqueKeys()
    {
        return Arrays.asList(Keys.KEY_USER_UK_UID, Keys.KEY_USER_UK_EMAIL);
    }

    @Override
    public User as(String alias)
    {
        return new User(DSL.name(alias), this);
    }

    @Override
    public User as(Name alias)
    {
        return new User(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(String name)
    {
        return new User(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public User rename(Name name)
    {
        return new User(name, null);
    }

    // -------------------------------------------------------------------------
    // Row18 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row18<ULong, String, String, String, String, String, String, String, LocalDate, UByte, String, String, String, String, UByte, UByte, LocalDateTime, LocalDateTime> fieldsRow()
    {
        return (Row18) super.fieldsRow();
    }
}
