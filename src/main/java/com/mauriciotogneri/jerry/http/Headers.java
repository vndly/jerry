package com.mauriciotogneri.jerry.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.ws.rs.core.MultivaluedMap;

public class Headers
{
    private final List<Header> headers;

    public Headers(List<Header> headers)
    {
        this.headers = headers;
    }

    public boolean isEmpty()
    {
        return headers.isEmpty();
    }

    public static Headers fromRequest(MultivaluedMap<String, String> map)
    {
        List<Header> headers = new ArrayList<>();

        for (Entry<String, List<String>> entry : map.entrySet())
        {
            headers.add(new Header(entry.getKey(), entry.getValue()));
        }

        return new Headers(headers);
    }

    public static Headers fromResponse(MultivaluedMap<String, Object> map)
    {
        List<Header> headers = new ArrayList<>();

        for (Entry<String, List<Object>> entry : map.entrySet())
        {

            headers.add(new Header(entry.getKey(), entry.getValue().stream().map(Object::toString).collect(Collectors.toList())));
        }

        return new Headers(headers);
    }

    @Override
    public String toString()
    {
        return String.join("\n", headers.stream().map(Header::toString).collect(Collectors.toList()));
    }
}