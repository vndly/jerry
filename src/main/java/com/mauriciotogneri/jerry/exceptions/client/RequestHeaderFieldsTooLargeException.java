package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class RequestHeaderFieldsTooLargeException extends WebApplicationException
{
    private static final Status STATUS = Status.REQUEST_HEADER_FIELDS_TOO_LARGE;

    public RequestHeaderFieldsTooLargeException()
    {
        super(STATUS);
    }

    public RequestHeaderFieldsTooLargeException(String message)
    {
        super(message, STATUS);
    }

    public RequestHeaderFieldsTooLargeException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public RequestHeaderFieldsTooLargeException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}