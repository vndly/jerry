package com.mauriciotogneri.jerry;

import com.mauriciotogneri.jerry.config.JerryConfig;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class Jerry
{
    public Server create(JerryConfig config)
    {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(config.port());
        connector.setHost(config.host());

        server.setConnectors(new Connector[] {connector});
        server.setErrorHandler(config.errorHandler());
        server.setHandler(config.handlers());
        server.addLifeCycleListener(config.lifeCycleListener());

        return server;
    }
}