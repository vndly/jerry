package com.mauriciotogneri.jerry;

import com.mauriciotogneri.jerry.error.CustomErrorHandler;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class Jerry
{
    public Server create(JerryConfig config)
    {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(config.port());
        connector.setHost(config.host());

        server.setConnectors(new Connector[] {connector});
        server.setErrorHandler(errorHandler());

        ServletHolder servlet = new ServletHolder(new ServletContainer(config.resourceConfig()));
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");

        ContextHandlerCollection contexts = new ContextHandlerCollection();
        contexts.setHandlers(config.handlers());
        server.setHandler(contexts);

        return server;
    }

    protected ErrorHandler errorHandler()
    {
        return new CustomErrorHandler();
    }
}