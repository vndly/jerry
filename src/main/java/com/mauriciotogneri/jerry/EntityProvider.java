package com.mauriciotogneri.jerry;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

public class EntityProvider<T> implements MessageBodyReader<T>
{
    private final Class<T> entityClass;

    private static final Gson gson = new Gson();

    protected EntityProvider(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }

    @Override
    public boolean isReadable(Class<?> clazz, Type type, Annotation[] annotations, MediaType mediaType)
    {
        return entityClass.isAssignableFrom(clazz);
    }

    @Override
    public T readFrom(Class<T> clazz, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return gson.fromJson(reader, entityClass);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}