package com.mauriciotogneri.jerry.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.container.ContainerRequestContext;

public class HttpRequest
{
    private final String method;
    private final String path;
    private final Headers headers;
    private final String entity;

    public HttpRequest(ContainerRequestContext request) throws IOException
    {
        this.method = request.getMethod();
        this.path = request.getUriInfo().getRequestUri().getPath();
        this.headers = Headers.fromRequest(request.getHeaders());

        if (request.hasEntity())
        {
            byte[] bytes = bytes(request.getEntityStream());
            request.setEntityStream(new ByteArrayInputStream(bytes));

            this.entity = new String(bytes);
        }
        else
        {
            this.entity = "";
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

    public Headers headers()
    {
        return headers;
    }

    public String entity()
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

        builder.append(String.format(
                "%s %s",
                method,
                path));

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