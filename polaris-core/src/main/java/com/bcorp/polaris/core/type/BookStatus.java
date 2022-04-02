package com.bcorp.polaris.core.type;

public enum BookStatus
{
    DRAFT(0),
    ACTIVE(1);

    private int value;

    BookStatus(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
