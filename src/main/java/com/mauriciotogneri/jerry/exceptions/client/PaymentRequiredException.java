package com.mauriciotogneri.jerry.exceptions.client;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

public class PaymentRequiredException extends WebApplicationException
{
    private static final Status STATUS = Status.PAYMENT_REQUIRED;

    public PaymentRequiredException()
    {
        super(STATUS);
    }

    public PaymentRequiredException(String message)
    {
        super(message, STATUS);
    }

    public PaymentRequiredException(Throwable throwable)
    {
        super(throwable, STATUS);
    }

    public PaymentRequiredException(String message, Throwable throwable)
    {
        super(message, throwable, STATUS);
    }
}