package com.bcorp.polaris.core.type;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;

import java.util.HashMap;
import java.util.Map;

public enum BookStatus
{
    DRAFT(0),

    PUBLISHED(1);

    private int value;

    BookStatus(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    private static final Map<Integer, BookStatus> map = new HashMap<Integer, BookStatus>();

    static
    {
        for (BookStatus type : BookStatus.values())
        {
            map.put(type.value, type);
        }
    }

    public static BookStatus fromValue(int i)
    {
        BookStatus type = map.get(i);
        if (type == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, "Not Enum constant was found for value : " + i);
        }
        return type;
    }
}
