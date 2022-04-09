package com.bcorp.polaris.storefront.constant;

import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;

import java.util.HashMap;
import java.util.Map;

public enum CartLineItemStatus
{
    UNAVAILABLE(0),

    PUBLISHED(1);

    private int value;

    CartLineItemStatus(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    private static final Map<Integer, CartLineItemStatus> map = new HashMap<Integer, CartLineItemStatus>();

    static
    {
        for (CartLineItemStatus type : CartLineItemStatus.values())
        {
            map.put(type.value, type);
        }
    }

    public static CartLineItemStatus fromValue(int i)
    {
        CartLineItemStatus type = map.get(i);
        if (type == null)
        {
            throw new PolarisServerRuntimeException(InternalErrorCode.INTERNAL_SERVER_ERROR, "Not Enum constant was found for value : " + i);
        }
        return type;
    }
}
