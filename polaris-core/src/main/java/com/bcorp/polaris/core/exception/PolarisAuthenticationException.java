package com.bcorp.polaris.core.exception;

public class PolarisAuthenticationException extends RuntimeException
{
    public PolarisAuthenticationException()
    {
    }

    public PolarisAuthenticationException(String message)
    {
        super(message);
    }

    public PolarisAuthenticationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PolarisAuthenticationException(Throwable cause)
    {
        super(cause);
    }
}
