package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class ForbiddenException extends WebApplicationException
{
    private static final Status STATUS = Status.FORBIDDEN;

    public ForbiddenException()
    {
        super(STATUS);
    }

    public ForbiddenException(String message)
    {
        super(message, STATUS);
    }

    public ForbiddenException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public ForbiddenException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}