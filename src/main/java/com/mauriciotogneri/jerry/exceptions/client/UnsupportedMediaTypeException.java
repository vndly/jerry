package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class UnsupportedMediaTypeException extends WebApplicationException
{
    private static final Status STATUS = Status.UNSUPPORTED_MEDIA_TYPE;

    public UnsupportedMediaTypeException()
    {
        super(STATUS);
    }

    public UnsupportedMediaTypeException(String message)
    {
        super(message, STATUS);
    }

    public UnsupportedMediaTypeException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public UnsupportedMediaTypeException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}