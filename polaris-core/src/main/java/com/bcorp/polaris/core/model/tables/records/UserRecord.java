/*
 * This file is generated by jOOQ.
 */
package com.bcorp.polaris.core.model.tables.records;


import com.bcorp.polaris.core.model.tables.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>polaris-db.user.id</code>.
     */
    public void setId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>polaris-db.user.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>polaris-db.user.name</code>. 使用者名稱
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>polaris-db.user.name</code>. 使用者名稱
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>polaris-db.user.title</code>. 頭銜
     */
    public void setTitle(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>polaris-db.user.title</code>. 頭銜
     */
    public String getTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>polaris-db.user.uid</code>. 使用者 Uid
     */
    public void setUid(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>polaris-db.user.uid</code>. 使用者 Uid
     */
    public String getUid() {
        return (String) get(3);
    }

    /**
     * Setter for <code>polaris-db.user.password</code>. 使用者密碼
     */
    public void setPassword(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>polaris-db.user.password</code>. 使用者密碼
     */
    public String getPassword() {
        return (String) get(4);
    }

    /**
     * Setter for <code>polaris-db.user.email</code>. 使用者 E-mail
     */
    public void setEmail(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>polaris-db.user.email</code>. 使用者 E-mail
     */
    public String getEmail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>polaris-db.user.avatar</code>. 使用者頭像
     */
    public void setAvatar(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>polaris-db.user.avatar</code>. 使用者頭像
     */
    public String getAvatar() {
        return (String) get(6);
    }

    /**
     * Setter for <code>polaris-db.user.short_bio</code>. 使用者簡短介紹
     */
    public void setShortBio(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>polaris-db.user.short_bio</code>. 使用者簡短介紹
     */
    public String getShortBio() {
        return (String) get(7);
    }

    /**
     * Setter for <code>polaris-db.user.full_bio</code>. 使用者完整介紹
     */
    public void setFullBio(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>polaris-db.user.full_bio</code>. 使用者完整介紹
     */
    public String getFullBio() {
        return (String) get(8);
    }

    /**
     * Setter for <code>polaris-db.user.birthday</code>. 使用者生日
     */
    public void setBirthday(LocalDate value) {
        set(9, value);
    }

    /**
     * Getter for <code>polaris-db.user.birthday</code>. 使用者生日
     */
    public LocalDate getBirthday() {
        return (LocalDate) get(9);
    }

    /**
     * Setter for <code>polaris-db.user.is_author</code>. 是否是作者，0-否，1-是，預設為 0
     */
    public void setIsAuthor(Byte value) {
        set(10, value);
    }

    /**
     * Getter for <code>polaris-db.user.is_author</code>. 是否是作者，0-否，1-是，預設為 0
     */
    public Byte getIsAuthor() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>polaris-db.user.twitter</code>.
     */
    public void setTwitter(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>polaris-db.user.twitter</code>.
     */
    public String getTwitter() {
        return (String) get(11);
    }

    /**
     * Setter for <code>polaris-db.user.github</code>.
     */
    public void setGithub(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>polaris-db.user.github</code>.
     */
    public String getGithub() {
        return (String) get(12);
    }

    /**
     * Setter for <code>polaris-db.user.linkedin</code>.
     */
    public void setLinkedin(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>polaris-db.user.linkedin</code>.
     */
    public String getLinkedin() {
        return (String) get(13);
    }

    /**
     * Setter for <code>polaris-db.user.facebook</code>.
     */
    public void setFacebook(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>polaris-db.user.facebook</code>.
     */
    public String getFacebook() {
        return (String) get(14);
    }

    /**
     * Setter for <code>polaris-db.user.youtube</code>.
     */
    public void setYoutube(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>polaris-db.user.youtube</code>.
     */
    public String getYoutube() {
        return (String) get(15);
    }

    /**
     * Setter for <code>polaris-db.user.website</code>.
     */
    public void setWebsite(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>polaris-db.user.website</code>.
     */
    public String getWebsite() {
        return (String) get(16);
    }

    /**
     * Setter for <code>polaris-db.user.default_payment_mode</code>. 付款方式
     */
    public void setDefaultPaymentMode(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>polaris-db.user.default_payment_mode</code>. 付款方式
     */
    public String getDefaultPaymentMode() {
        return (String) get(17);
    }

    /**
     * Setter for <code>polaris-db.user.default_invoice_type</code>.
     * 發票類型，1-個人，2-公司，3-捐贈
     */
    public void setDefaultInvoiceType(Byte value) {
        set(18, value);
    }

    /**
     * Getter for <code>polaris-db.user.default_invoice_type</code>.
     * 發票類型，1-個人，2-公司，3-捐贈
     */
    public Byte getDefaultInvoiceType() {
        return (Byte) get(18);
    }

    /**
     * Setter for <code>polaris-db.user.is_blocked</code>. 是否停權，0-否，1-是，預設為 0
     */
    public void setIsBlocked(Byte value) {
        set(19, value);
    }

    /**
     * Getter for <code>polaris-db.user.is_blocked</code>. 是否停權，0-否，1-是，預設為 0
     */
    public Byte getIsBlocked() {
        return (Byte) get(19);
    }

    /**
     * Setter for <code>polaris-db.user.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public void setIsDeleted(Byte value) {
        set(20, value);
    }

    /**
     * Getter for <code>polaris-db.user.is_deleted</code>. 是否刪除，0-未刪除，1-刪除，預設為 0
     */
    public Byte getIsDeleted() {
        return (Byte) get(20);
    }

    /**
     * Setter for <code>polaris-db.user.created_at</code>. 建立時間
     */
    public void setCreatedAt(LocalDateTime value) {
        set(21, value);
    }

    /**
     * Getter for <code>polaris-db.user.created_at</code>. 建立時間
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(21);
    }

    /**
     * Setter for <code>polaris-db.user.updated_at</code>. 修改時間
     */
    public void setUpdatedAt(LocalDateTime value) {
        set(22, value);
    }

    /**
     * Getter for <code>polaris-db.user.updated_at</code>. 修改時間
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(22);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Long id, String name, String title, String uid, String password, String email, String avatar, String shortBio, String fullBio, LocalDate birthday, Byte isAuthor, String twitter, String github, String linkedin, String facebook, String youtube, String website, String defaultPaymentMode, Byte defaultInvoiceType, Byte isBlocked, Byte isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(User.USER);

        setId(id);
        setName(name);
        setTitle(title);
        setUid(uid);
        setPassword(password);
        setEmail(email);
        setAvatar(avatar);
        setShortBio(shortBio);
        setFullBio(fullBio);
        setBirthday(birthday);
        setIsAuthor(isAuthor);
        setTwitter(twitter);
        setGithub(github);
        setLinkedin(linkedin);
        setFacebook(facebook);
        setYoutube(youtube);
        setWebsite(website);
        setDefaultPaymentMode(defaultPaymentMode);
        setDefaultInvoiceType(defaultInvoiceType);
        setIsBlocked(isBlocked);
        setIsDeleted(isDeleted);
        setCreatedAt(createdAt);
        setUpdatedAt(updatedAt);
    }
}
