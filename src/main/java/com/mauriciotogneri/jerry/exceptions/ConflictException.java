package com.mauriciotogneri.jerry.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class ConflictException extends WebApplicationException
{
    public ConflictException()
    {
        super(Status.CONFLICT);
    }

    public ConflictException(String message)
    {
        super(message, Status.CONFLICT);
    }

    public ConflictException(Throwable throwable)
    {
        super(throwable, Status.CONFLICT);
    }

    public ConflictException(String message, Throwable throwable)
    {
        super(message, throwable, Status.CONFLICT);
    }
}