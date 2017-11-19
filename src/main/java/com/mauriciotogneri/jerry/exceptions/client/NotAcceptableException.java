package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class NotAcceptableException extends WebApplicationException
{
    private static final Status STATUS = Status.NOT_ACCEPTABLE;

    public NotAcceptableException()
    {
        super(STATUS);
    }

    public NotAcceptableException(String message)
    {
        super(message, STATUS);
    }

    public NotAcceptableException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public NotAcceptableException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}