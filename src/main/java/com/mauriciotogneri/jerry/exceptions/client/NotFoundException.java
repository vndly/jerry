package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class NotFoundException extends WebApplicationException
{
    private static final Status STATUS = Status.NOT_FOUND;

    public NotFoundException()
    {
        super(STATUS);
    }

    public NotFoundException(String message)
    {
        super(message, STATUS);
    }

    public NotFoundException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public NotFoundException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}