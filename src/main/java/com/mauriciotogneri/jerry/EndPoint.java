package com.mauriciotogneri.jerry;

import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class EndPoint
{
    protected Response error(Status status)
    {
        return Response.status(status).build();
    }

    protected String json(Object object)
    {
        return new Gson().toJson(object);
    }

    protected <T> T json(Class<T> clazz, String json)
    {
        return new Gson().fromJson(json, clazz);
    }
}