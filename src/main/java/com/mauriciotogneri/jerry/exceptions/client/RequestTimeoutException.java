package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class RequestTimeoutException extends WebApplicationException
{
    private static final Status STATUS = Status.REQUEST_TIMEOUT;

    public RequestTimeoutException()
    {
        super(STATUS);
    }

    public RequestTimeoutException(String message)
    {
        super(message, STATUS);
    }

    public RequestTimeoutException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public RequestTimeoutException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}