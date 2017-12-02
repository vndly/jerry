package com.mauriciotogneri.jerry.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MediaType;

public class HttpResponse
{
    private final int status;
    private final String statusText;
    private final Headers headers;
    private final String entity;

    private static final JsonParser parser = new JsonParser();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public HttpResponse(ContainerResponseContext response)
    {
        this.status = response.getStatus();
        this.statusText = response.getStatusInfo().getReasonPhrase();
        this.headers = Headers.fromResponse(response.getHeaders());

        if (response.hasEntity())
        {
            if (response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE))
            {
                this.entity = gson.toJson(parser.parse(response.getEntity().toString()));
            }
            else
            {
                this.entity = response.getEntity().toString();
            }
        }
        else
        {
            this.entity = "";
        }
    }

    public int status()
    {
        return status;
    }

    public Headers headers()
    {
        return headers;
    }

    public String entity()
    {
        return entity;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(
                "%s %s",
                status,
                statusText));

        if (!headers.isEmpty())
        {
            builder.append(String.format(
                    "%n%s",
                    headers.toString()
            ));
        }

        if (!entity.isEmpty())
        {
            builder.append(String.format(
                    "%n%s",
                    entity));
        }

        return builder.toString();
    }
}