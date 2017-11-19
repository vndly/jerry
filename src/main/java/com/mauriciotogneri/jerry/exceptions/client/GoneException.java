package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class GoneException extends WebApplicationException
{
    private static final Status STATUS = Status.GONE;

    public GoneException()
    {
        super(STATUS);
    }

    public GoneException(String message)
    {
        super(message, STATUS);
    }

    public GoneException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public GoneException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}