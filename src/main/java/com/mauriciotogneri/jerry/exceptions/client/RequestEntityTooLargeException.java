package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class RequestEntityTooLargeException extends WebApplicationException
{
    private static final Status STATUS = Status.REQUEST_ENTITY_TOO_LARGE;

    public RequestEntityTooLargeException()
    {
        super(STATUS);
    }

    public RequestEntityTooLargeException(String message)
    {
        super(message, STATUS);
    }

    public RequestEntityTooLargeException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public RequestEntityTooLargeException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}