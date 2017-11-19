package com.mauriciotogneri.jerry;

import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

public class EndPoint
{
    private static final Gson gson = new Gson();

    protected Response response(Status status, Object entity, Header... headers)
    {
        ResponseBuilder builder = Response.status(status);

        if (entity != null)
        {
            builder = builder.entity(gson.toJson(entity));
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

    protected Response response(Status status)
    {
        return response(status, null, new Header[0]);
    }
}