package com.mauriciotogneri.jerry.logging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.util.List;
import java.util.Map.Entry;

import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.MediaType;

public class ResponseLogger
{
    private static final JsonParser parser = new JsonParser();
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static String log(ContainerResponseContext response)
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            builder.append(String.format(
                    "%s %s%n",
                    response.getStatus(),
                    response.getStatusInfo().getReasonPhrase()));

            for (Entry<String, List<Object>> entry : response.getHeaders().entrySet())
            {
                builder.append(String.format(
                        "%n%s: %s",
                        entry.getKey(),
                        String.join(", ", entry.getValue().toString())));
            }

            if (!response.getHeaders().isEmpty())
            {
                builder.append(String.format("%n"));
            }

            if ((response.getLength() > 0) && response.hasEntity())
            {
                if (response.getMediaType().isCompatible(MediaType.APPLICATION_JSON_TYPE))
                {
                    builder.append(String.format(
                            "%n%s",
                            gson.toJson(parser.parse(response.getEntity().toString()))));
                }
                else
                {
                    builder.append(String.format(
                            "%n%s",
                            response.getEntity().toString()));
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
}