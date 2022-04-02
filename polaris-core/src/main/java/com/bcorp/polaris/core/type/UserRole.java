package com.bcorp.polaris.core.type;

public enum UserRole
{
    AUTHOR(1),
    ;

    private int value;

    UserRole(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
