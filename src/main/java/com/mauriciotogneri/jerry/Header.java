package com.mauriciotogneri.jerry;

public class Header
{
    private final String key;
    private final String value;

    public Header(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public String key()
    {
        return key;
    }

    public String value()
    {
        return value;
    }
}