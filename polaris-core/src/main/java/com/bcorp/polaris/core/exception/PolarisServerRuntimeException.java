package com.bcorp.polaris.core.exception;

import com.bcorp.polaris.core.error.InternalErrorCode;

import java.util.List;

public class PolarisServerRuntimeException extends RuntimeException
{
    private InternalErrorCode errorCode;
    private List<Object> errors;

    public PolarisServerRuntimeException(InternalErrorCode errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }

    public PolarisServerRuntimeException(InternalErrorCode errorCode, String message, List<Object> errors)
    {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
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
