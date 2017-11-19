package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class MethodNotAllowedException extends WebApplicationException
{
    private static final Status STATUS = Status.METHOD_NOT_ALLOWED;

    public MethodNotAllowedException()
    {
        super(STATUS);
    }

    public MethodNotAllowedException(String message)
    {
        super(message, STATUS);
    }

    public MethodNotAllowedException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public MethodNotAllowedException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}