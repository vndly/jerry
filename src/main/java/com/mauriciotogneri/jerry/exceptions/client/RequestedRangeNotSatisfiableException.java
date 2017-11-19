package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class RequestedRangeNotSatisfiableException extends WebApplicationException
{
    private static final Status STATUS = Status.REQUESTED_RANGE_NOT_SATISFIABLE;

    public RequestedRangeNotSatisfiableException()
    {
        super(STATUS);
    }

    public RequestedRangeNotSatisfiableException(String message)
    {
        super(message, STATUS);
    }

    public RequestedRangeNotSatisfiableException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public RequestedRangeNotSatisfiableException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}