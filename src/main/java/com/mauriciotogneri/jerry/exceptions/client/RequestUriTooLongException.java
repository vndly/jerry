package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class RequestUriTooLongException extends WebApplicationException
{
    private static final Status STATUS = Status.REQUEST_URI_TOO_LONG;

    public RequestUriTooLongException()
    {
        super(STATUS);
    }

    public RequestUriTooLongException(String message)
    {
        super(message, STATUS);
    }

    public RequestUriTooLongException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public RequestUriTooLongException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}