package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class ConflictException extends WebApplicationException
{
    private static final Status STATUS = Status.CONFLICT;

    public ConflictException()
    {
        super(STATUS);
    }

    public ConflictException(String message)
    {
        super(message, STATUS);
    }

    public ConflictException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public ConflictException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}