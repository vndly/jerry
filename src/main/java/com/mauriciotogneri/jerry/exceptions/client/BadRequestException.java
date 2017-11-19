package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class BadRequestException extends WebApplicationException
{
    private static final Status STATUS = Status.BAD_REQUEST;

    public BadRequestException()
    {
        super(STATUS);
    }

    public BadRequestException(String message)
    {
        super(message, STATUS);
    }

    public BadRequestException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public BadRequestException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}