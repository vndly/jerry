package com.mauriciotogneri.jerry.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class ConflictException extends WebApplicationException
{
    public ConflictException()
    {
        super(Status.CONFLICT);
    }
}