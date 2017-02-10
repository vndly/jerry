package com.mauriciotogneri.jerry.kernel;

import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public class EndPoint
{
    protected Response response(Status status, Object entity, Header... headers)
    {
        ResponseBuilder builder = Response.status(status);

        if (entity != null)
        {
            builder = builder.entity(json(entity));
        }

        for (Header header : headers)
        {
            builder = builder.header(header.key(), header.value());
        }

        return builder.build();
    }

    protected Response response(Status status, Header... headers)
    {
        return response(status, null, headers);
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