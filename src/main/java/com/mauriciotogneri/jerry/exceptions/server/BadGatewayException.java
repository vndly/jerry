package com.mauriciotogneri.jerry.exceptions.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class BadGatewayException extends WebApplicationException
{
    private static final Status STATUS = Status.BAD_GATEWAY;

    public BadGatewayException()
    {
        super(STATUS);
    }

    public BadGatewayException(String message)
    {
        super(message, STATUS);
    }

    public BadGatewayException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public BadGatewayException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}