package com.mauriciotogneri.jerry.http;

import java.util.Collections;
import java.util.List;

public class Header
{
    private final String key;
    private final List<String> value;

    public Header(String key, List<String> value)
    {
        this.key = key;
        this.value = value;
    }

    public Header(String key, String value)
    {
        this(key, Collections.singletonList(value));
    }

    public String key()
    {
        return key;
    }

    public String value()
    {
        return String.join(", ", value);
    }

    @Override
    public String toString()
    {
        return String.format(
                "%s: %s",
                key,
                String.join(", ", value));
    }
}