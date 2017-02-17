package com.mauriciotogneri.jerry.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class InternalServerErrorException extends WebApplicationException
{
    public InternalServerErrorException()
    {
        super(Status.INTERNAL_SERVER_ERROR);
    }
}