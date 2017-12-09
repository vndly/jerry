package com.mauriciotogneri.jerry;

import org.eclipse.jetty.server.Handler;
import org.glassfish.jersey.server.ResourceConfig;

public class JerryConfig
{
    private final int port;
    private final String host;
    private final ResourceConfig config;
    private final Handler[] handlers;

    public JerryConfig(int port, String host, ResourceConfig config, Handler[] handlers)
    {
        this.port = port;
        this.host = host;
        this.config = config;
        this.handlers = handlers;
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

    public Handler[] handlers()
    {
        return handlers;
    }
}