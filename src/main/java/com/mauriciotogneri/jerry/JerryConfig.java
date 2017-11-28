package com.mauriciotogneri.jerry;

import org.glassfish.jersey.server.ResourceConfig;

public class JerryConfig
{
    private final int port;
    private final String host;
    private final ResourceConfig config;

    public JerryConfig(int port, String host, ResourceConfig config)
    {
        this.port = port;
        this.host = host;
        this.config = config;
    }

    public int port()
    {
        return port;
    }

    public String host()
    {
        return host;
    }

    public ResourceConfig resourceConfig()
    {
        return config;
    }
}