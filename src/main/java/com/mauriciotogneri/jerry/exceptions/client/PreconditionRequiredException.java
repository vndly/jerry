package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class PreconditionRequiredException extends WebApplicationException
{
    private static final Status STATUS = Status.PRECONDITION_REQUIRED;

    public PreconditionRequiredException()
    {
        super(STATUS);
    }

    public PreconditionRequiredException(String message)
    {
        super(message, STATUS);
    }

    public PreconditionRequiredException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public PreconditionRequiredException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}