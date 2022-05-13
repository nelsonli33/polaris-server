package com.bcorp.polaris.core.error;

import java.util.Arrays;

public enum InternalErrorCode
{
    SUCCESS(0),
    INVALID_REQUEST_BODY(33),
    RECORD_NOT_FOUND(34),
    ENUM_CODE_NOT_FOUND(35),

    UPLOAD_ERROR(36),

    // Account 100 ~ 200
    USER_LOGIN_FAILED(100),
    USER_ACCOUNT_EXISTS(101),

    // Cart 300 ~ 400
    ADD_TO_CART_ERROR(300),
    REMOVE_CART_LINE_ITEM_ERROR(301),


    // Checkout 401 ~ 500
    CART_CHECKOUT_ERROR(401),
    EMPTY_CART_ERROR(402),
    CART_ITEMS_CHANGED(403),
    INVOICE_LOVE_CODE_ERROR(406),
    INVOICE_LOVE_CODE_NOT_EXIST(407),

    // Order 501 ~ 600
    ORDER_NOT_FOUND(501),


    // Chapters 601 ~ 700
    Exceed_MAXIMUM_CHAPTER_COUNT(601),

    INTERNAL_SERVER_ERROR(999);

    private final int code;

    InternalErrorCode(int code)
    {
        this.code = code;
    }

    public static InternalErrorCode fromCode(int code)
    {
        return Arrays
                .stream(InternalErrorCode.values()).filter(e -> e.code == code)
                .findFirst()
                .get();
    }

    public int getCode()
    {
        return code;
    }
}
