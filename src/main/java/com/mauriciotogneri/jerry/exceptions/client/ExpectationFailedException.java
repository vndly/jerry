package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class ExpectationFailedException extends WebApplicationException
{
    private static final Status STATUS = Status.EXPECTATION_FAILED;

    public ExpectationFailedException()
    {
        super(STATUS);
    }

    public ExpectationFailedException(String message)
    {
        super(message, STATUS);
    }

    public ExpectationFailedException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public ExpectationFailedException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}