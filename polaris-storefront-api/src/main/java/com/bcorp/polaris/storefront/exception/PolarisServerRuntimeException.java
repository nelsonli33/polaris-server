package com.bcorp.polaris.storefront.exception;

import com.bcorp.polaris.storefront.error.InternalErrorCode;

public class PolarisServerRuntimeException extends RuntimeException
{
    private final InternalErrorCode errorCode;

    public PolarisServerRuntimeException(InternalErrorCode errorCode)
    {
        this.errorCode = errorCode;
    }

    public PolarisServerRuntimeException(InternalErrorCode errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }

    public PolarisServerRuntimeException(InternalErrorCode errorCode, String message, Throwable cause)
    {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public PolarisServerRuntimeException(InternalErrorCode errorCode, Throwable cause)
    {
        super(cause);
        this.errorCode = errorCode;
    }

    public InternalErrorCode getErrorCode()
    {
        return errorCode;
    }
}
