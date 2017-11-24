package com.mauriciotogneri.jerry.logging;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.container.ContainerRequestContext;

public class RequestLogger
{
    public static String log(ContainerRequestContext request)
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            builder.append(String.format(
                    "%s %s%n",
                    request.getMethod(),
                    request.getUriInfo().getRequestUri().getPath()));

            for (Entry<String, List<String>> entry : request.getHeaders().entrySet())
            {
                builder.append(String.format(
                        "%n%s: %s",
                        entry.getKey(),
                        String.join(", ", entry.getValue())));
            }

            if (!request.getHeaders().isEmpty())
            {
                builder.append(String.format("%n"));
            }

            if ((request.getLength() > 0) && request.hasEntity())
            {
                byte[] entity = bytes(request.getEntityStream());

                if (entity.length > 0)
                {
                    builder.append(String.format(
                            "%n%s",
                            new String(entity, StandardCharsets.UTF_8.name())));

                    request.setEntityStream(new ByteInputStream(entity, entity.length));
                }
            }

            builder.append(String.format("%n%n"));
        }
        catch (Exception e)
        {
            // ignore
        }

        return builder.toString();
    }

    private static byte[] bytes(InputStream inputStream) throws IOException
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
}