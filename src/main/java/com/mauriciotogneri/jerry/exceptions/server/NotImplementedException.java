package com.mauriciotogneri.jerry.exceptions.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class NotImplementedException extends WebApplicationException
{
    private static final Status STATUS = Status.NOT_IMPLEMENTED;

    public NotImplementedException()
    {
        super(STATUS);
    }

    public NotImplementedException(String message)
    {
        super(message, STATUS);
    }

    public NotImplementedException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public NotImplementedException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}