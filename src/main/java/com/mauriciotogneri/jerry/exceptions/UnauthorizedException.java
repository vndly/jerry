package com.mauriciotogneri.jerry.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class UnauthorizedException extends WebApplicationException
{
    public UnauthorizedException()
    {
        super(Status.UNAUTHORIZED);
    }
}