package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class PreconditionFailedException extends WebApplicationException
{
    private static final Status STATUS = Status.PRECONDITION_FAILED;

    public PreconditionFailedException()
    {
        super(STATUS);
    }

    public PreconditionFailedException(String message)
    {
        super(message, STATUS);
    }

    public PreconditionFailedException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public PreconditionFailedException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}