package com.mauriciotogneri.jerry.config;

import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.component.LifeCycle.Listener;

public class JerryConfig
{
    private final int port;
    private final String host;
    private final HandlerList handlers;
    private final ErrorHandler errorHandler;
    private final LifeCycle.Listener lifeCycleListener;

    public JerryConfig(int port, String host, HandlerList handlers, ErrorHandler errorHandler, Listener lifeCycleListener)
    {
        this.port = port;
        this.host = host;
        this.handlers = handlers;
        this.errorHandler = errorHandler;
        this.lifeCycleListener = lifeCycleListener;
    }

    public int port()
    {
        return port;
    }

    public String host()
    {
        return host;
    }

    public HandlerList handlers()
    {
        return handlers;
    }

    public ErrorHandler errorHandler()
    {
        return errorHandler;
    }

    public LifeCycle.Listener lifeCycleListener()
    {
        return lifeCycleListener;
    }

    public static class Builder
    {
        private int port = 8080;
        private String host = "0.0.0.0";
        private HandlerList handlers = new HandlerList();
        private ErrorHandler errorHandler = new DefaultErrorHandler();
        private LifeCycle.Listener lifeCycleListener = new DefaultLifeCycleListener();

        public Builder port(int port)
        {
            this.port = port;

            return this;
        }

        public Builder host(String host)
        {
            this.host = host;

            return this;
        }

        public Builder handlers(HandlerList handlers)
        {
            this.handlers = handlers;

            return this;
        }

        public Builder errorHandler(ErrorHandler errorHandler)
        {
            this.errorHandler = errorHandler;

            return this;
        }

        public Builder lifeCycleListener(LifeCycle.Listener lifeCycleListener)
        {
            this.lifeCycleListener = lifeCycleListener;

            return this;
        }

        public JerryConfig build()
        {
            return new JerryConfig(port, host, handlers, errorHandler, lifeCycleListener);
        }
    }
}