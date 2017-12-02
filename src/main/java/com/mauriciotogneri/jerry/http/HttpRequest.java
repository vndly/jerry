package com.mauriciotogneri.jerry.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.container.ContainerRequestContext;

public class HttpRequest
{
    private final String method;
    private final String path;
    private final Map<String, List<String>> headers;
    private final byte[] entity;

    public HttpRequest(ContainerRequestContext request) throws IOException
    {
        this.method = request.getMethod();
        this.path = request.getUriInfo().getRequestUri().getPath();

        this.headers = new HashMap<>();

        for (Entry<String, List<String>> entry : request.getHeaders().entrySet())
        {
            this.headers.put(entry.getKey(), entry.getValue());
        }

        if (request.hasEntity())
        {
            this.entity = bytes(request.getEntityStream());
            request.setEntityStream(new ByteArrayInputStream(this.entity));
        }
        else
        {
            this.entity = new byte[0];
        }
    }

    public String method()
    {
        return method;
    }

    public String path()
    {
        return path;
    }

    public Map<String, List<String>> headers()
    {
        return headers;
    }

    public byte[] entity()
    {
        return entity;
    }

    private byte[] bytes(InputStream inputStream) throws IOException
    {
        int read;
        byte[] buffer = new byte[1024];

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        while ((read = inputStream.read(buffer, 0, buffer.length)) != -1)
        {
            bos.write(buffer, 0, read);
        }

        return bos.toByteArray();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            builder.append(String.format(
                    "%s %s%n",
                    method,
                    path));

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

            if (entity.length > 0)
            {
                builder.append(String.format(
                        "%n%s",
                        new String(entity, StandardCharsets.UTF_8.name())));
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