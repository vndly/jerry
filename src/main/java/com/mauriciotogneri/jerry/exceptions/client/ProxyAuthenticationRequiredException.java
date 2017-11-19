package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class ProxyAuthenticationRequiredException extends WebApplicationException
{
    private static final Status STATUS = Status.PROXY_AUTHENTICATION_REQUIRED;

    public ProxyAuthenticationRequiredException()
    {
        super(STATUS);
    }

    public ProxyAuthenticationRequiredException(String message)
    {
        super(message, STATUS);
    }

    public ProxyAuthenticationRequiredException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public ProxyAuthenticationRequiredException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}