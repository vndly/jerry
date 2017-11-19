package com.mauriciotogneri.jerry.exceptions.server;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class InternalServerErrorException extends WebApplicationException
{
    private static final Status STATUS = Status.INTERNAL_SERVER_ERROR;

    public InternalServerErrorException()
    {
        super(STATUS);
    }

    public InternalServerErrorException(String message)
    {
        super(message, STATUS);
    }

    public InternalServerErrorException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public InternalServerErrorException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}