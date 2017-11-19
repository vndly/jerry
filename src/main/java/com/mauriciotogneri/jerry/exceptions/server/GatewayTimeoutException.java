package com.mauriciotogneri.jerry.exceptions.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class GatewayTimeoutException extends WebApplicationException
{
    private static final Status STATUS = Status.GATEWAY_TIMEOUT;

    public GatewayTimeoutException()
    {
        super(STATUS);
    }

    public GatewayTimeoutException(String message)
    {
        super(message, STATUS);
    }

    public GatewayTimeoutException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public GatewayTimeoutException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}