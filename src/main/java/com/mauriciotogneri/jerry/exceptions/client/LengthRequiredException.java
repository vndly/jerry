package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class LengthRequiredException extends WebApplicationException
{
    private static final Status STATUS = Status.LENGTH_REQUIRED;

    public LengthRequiredException()
    {
        super(STATUS);
    }

    public LengthRequiredException(String message)
    {
        super(message, STATUS);
    }

    public LengthRequiredException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public LengthRequiredException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}