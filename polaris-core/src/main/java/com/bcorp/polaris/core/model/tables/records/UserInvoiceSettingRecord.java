/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables.records;


import com.bcorp.polaris.core.model.tables.UserInvoiceSetting;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserInvoiceSettingRecord extends UpdatableRecordImpl<UserInvoiceSettingRecord> implements Record9<Long, Byte, String, String, String, String, Byte, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>polaris-db.user_invoice_setting.user_id</code>. 使用者 id
     */
    public void setUserId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.user_id</code>. 使用者 id
     */
    public Long getUserId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.invoice_type</code>.
     * 發票類型，1-個人，2-公司，3-捐贈
     */
    public void setInvoiceType(Byte value) {
        set(1, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.invoice_type</code>.
     * 發票類型，1-個人，2-公司，3-捐贈
     */
    public Byte getInvoiceType() {
        return (Byte) get(1);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.contact_email</code>.
     */
    public void setContactEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.contact_email</code>.
     */
    public String getContactEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.invoice_title</code>.
     */
    public void setInvoiceTitle(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.invoice_title</code>.
     */
    public String getInvoiceTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.business_number</code>.
     */
    public void setBusinessNumber(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.business_number</code>.
     */
    public String getBusinessNumber() {
        return (String) get(4);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.lovecode</code>.
     */
    public void setLovecode(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.lovecode</code>.
     */
    public String getLovecode() {
        return (String) get(5);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.is_deleted</code>.
     * 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public void setIsDeleted(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.is_deleted</code>.
     * 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public Byte getIsDeleted() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.created_at</code>. 建立時間
     */
    public void setCreatedAt(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.created_at</code>. 建立時間
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>polaris-db.user_invoice_setting.updated_at</code>. 修改時間
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>polaris-db.user_invoice_setting.updated_at</code>. 修改時間
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Long, Byte> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row9<Long, Byte, String, String, String, String, Byte, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    @Override
    public Row9<Long, Byte, String, String, String, String, Byte, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row9) super.valuesRow();
    }

    @Override
    public Field<Long> field1() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.USER_ID;
    }

    @Override
    public Field<Byte> field2() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.INVOICE_TYPE;
    }

    @Override
    public Field<String> field3() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.CONTACT_EMAIL;
    }

    @Override
    public Field<String> field4() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.INVOICE_TITLE;
    }

    @Override
    public Field<String> field5() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.BUSINESS_NUMBER;
    }

    @Override
    public Field<String> field6() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.LOVECODE;
    }

    @Override
    public Field<Byte> field7() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.IS_DELETED;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return UserInvoiceSetting.USER_INVOICE_SETTING.UPDATED_AT;
    }

    @Override
    public Long component1() {
        return getUserId();
    }

    @Override
    public Byte component2() {
        return getInvoiceType();
    }

    @Override
    public String component3() {
        return getContactEmail();
    }

    @Override
    public String component4() {
        return getInvoiceTitle();
    }

    @Override
    public String component5() {
        return getBusinessNumber();
    }

    @Override
    public String component6() {
        return getLovecode();
    }

    @Override
    public Byte component7() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime component8() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component9() {
        return getUpdatedAt();
    }

    @Override
    public Long value1() {
        return getUserId();
    }

    @Override
    public Byte value2() {
        return getInvoiceType();
    }

    @Override
    public String value3() {
        return getContactEmail();
    }

    @Override
    public String value4() {
        return getInvoiceTitle();
    }

    @Override
    public String value5() {
        return getBusinessNumber();
    }

    @Override
    public String value6() {
        return getLovecode();
    }

    @Override
    public Byte value7() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime value8() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value9() {
        return getUpdatedAt();
    }

    @Override
    public UserInvoiceSettingRecord value1(Long value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value2(Byte value) {
        setInvoiceType(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value3(String value) {
        setContactEmail(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value4(String value) {
        setInvoiceTitle(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value5(String value) {
        setBusinessNumber(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value6(String value) {
        setLovecode(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value7(Byte value) {
        setIsDeleted(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value8(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord value9(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public UserInvoiceSettingRecord values(Long value1, Byte value2, String value3, String value4, String value5, String value6, Byte value7, LocalDateTime value8, LocalDateTime value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserInvoiceSettingRecord
     */
    public UserInvoiceSettingRecord() {
        super(UserInvoiceSetting.USER_INVOICE_SETTING);
    }

    /**
     * Create a detached, initialised UserInvoiceSettingRecord
     */
    public UserInvoiceSettingRecord(Long userId, Byte invoiceType, String contactEmail, String invoiceTitle, String businessNumber, String lovecode, Byte isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(UserInvoiceSetting.USER_INVOICE_SETTING);

        setUserId(userId);
        setInvoiceType(invoiceType);
        setContactEmail(contactEmail);
        setInvoiceTitle(invoiceTitle);
        setBusinessNumber(businessNumber);
        setLovecode(lovecode);
        setIsDeleted(isDeleted);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }
}