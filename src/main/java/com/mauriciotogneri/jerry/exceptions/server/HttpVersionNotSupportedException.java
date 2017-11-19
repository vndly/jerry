package com.mauriciotogneri.jerry.exceptions.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class HttpVersionNotSupportedException extends WebApplicationException
{
    private static final Status STATUS = Status.HTTP_VERSION_NOT_SUPPORTED;

    public HttpVersionNotSupportedException()
    {
        super(STATUS);
    }

    public HttpVersionNotSupportedException(String message)
    {
        super(message, STATUS);
    }

    public HttpVersionNotSupportedException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public HttpVersionNotSupportedException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}