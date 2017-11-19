package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class UnauthorizedException extends WebApplicationException
{
    private static final Status STATUS = Status.UNAUTHORIZED;

    public UnauthorizedException()
    {
        super(STATUS);
    }

    public UnauthorizedException(String message)
    {
        super(message, STATUS);
    }

    public UnauthorizedException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public UnauthorizedException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}