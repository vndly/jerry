package com.mauriciotogneri.jerry.exceptions.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class ServiceUnavailableException extends WebApplicationException
{
    private static final Status STATUS = Status.SERVICE_UNAVAILABLE;

    public ServiceUnavailableException()
    {
        super(STATUS);
    }

    public ServiceUnavailableException(String message)
    {
        super(message, STATUS);
    }

    public ServiceUnavailableException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public ServiceUnavailableException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}