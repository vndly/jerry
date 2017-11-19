package com.mauriciotogneri.jerry.exceptions.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class NetworkAuthenticationRequiredException extends WebApplicationException
{
    private static final Status STATUS = Status.NETWORK_AUTHENTICATION_REQUIRED;

    public NetworkAuthenticationRequiredException()
    {
        super(STATUS);
    }

    public NetworkAuthenticationRequiredException(String message)
    {
        super(message, STATUS);
    }

    public NetworkAuthenticationRequiredException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public NetworkAuthenticationRequiredException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}