package com.mauriciotogneri.jerry.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MediaType;

public class HttpResponse
{
    private final int status;
    private final String statusText;
    private final Map<String, List<String>> headers;
    private final String entity;

    private static final JsonParser parser = new JsonParser();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public HttpResponse(ContainerResponseContext response)
    {
        this.status = response.getStatus();
        this.statusText = response.getStatusInfo().getReasonPhrase();

        this.headers = new HashMap<>();

        for (Entry<String, List<Object>> entry : response.getHeaders().entrySet())
        {
            this.headers.put(entry.getKey(), entry.getValue().stream().map(Object::toString).collect(Collectors.toList()));
        }

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

    public Map<String, List<String>> headers()
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

        try
        {
            builder.append(String.format(
                    "%s %s%n",
                    status,
                    statusText));

            for (Entry<String, List<String>> entry : headers.entrySet())
            {
                builder.append(String.format(
                        "%n%s: %s",
                        entry.getKey(),
                        String.join(", ", entry.getValue())));
            }

            if (!headers.isEmpty())
            {
                builder.append(String.format("%n"));
            }

            if (!entity.isEmpty())
            {
                builder.append(String.format(
                        "%n%s",
                        entity));
            }

            builder.append(String.format("%n%n"));
        }
        catch (Exception e)
        {
            // ignore
        }

        return builder.toString();
    }
}