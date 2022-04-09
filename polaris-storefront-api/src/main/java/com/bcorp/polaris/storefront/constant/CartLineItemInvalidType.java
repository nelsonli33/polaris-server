package com.bcorp.polaris.storefront.constant;

public enum CartLineItemInvalidType
{
    BOOK_UNAVAILABLE(1),

    BOOK_INFO_HAS_CHANGED(2);

    private int value;

    CartLineItemInvalidType(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
