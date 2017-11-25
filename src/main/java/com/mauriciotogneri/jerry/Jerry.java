package com.mauriciotogneri.jerry;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class Jerry
{
    public enum Mode
    {
        REMOTE,
        LOCAL
    }

    public Server create(int port, Mode mode, String packages) throws Exception
    {
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);

        if (mode == Mode.LOCAL)
        {
            connector.setHost("localhost");
        }

        server.setConnectors(new Connector[] {connector});
        server.setHandler(context);
        server.setErrorHandler(errorHandler());

        ServletHolder servlet = context.addServlet(ServletContainer.class, "/*");
        servlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, packages);

        return server;
    }

    public Server create(int port, Mode mode, Package packages) throws Exception
    {
        return create(port, mode, packages.getName());
    }

    protected ErrorHandler errorHandler()
    {
        return new CustomErrorHandler();
    }
}