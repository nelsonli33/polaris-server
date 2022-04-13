package com.bcorp.polaris.core.util;

import com.bcorp.polaris.core.constant.CodeEnum;
import com.bcorp.polaris.core.error.InternalErrorCode;
import com.bcorp.polaris.core.exception.PolarisServerRuntimeException;

public class EnumUtil
{
    public static <T extends CodeEnum> T getByCode(Object code, Class<T> enumClass)
    {
        for (T each : enumClass.getEnumConstants())
        {
            if (code.equals(each.getCode()))
            {
                return each;
            }
        }
        throw new PolarisServerRuntimeException(InternalErrorCode.ENUM_CODE_NOT_FOUND, "Enum:[" + enumClass.getName() + "] with code: " + code + "not found.");
    }
}
