package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class TooManyRequestsException extends WebApplicationException
{
    private static final Status STATUS = Status.TOO_MANY_REQUESTS;

    public TooManyRequestsException()
    {
        super(STATUS);
    }

    public TooManyRequestsException(String message)
    {
        super(message, STATUS);
    }

    public TooManyRequestsException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public TooManyRequestsException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}