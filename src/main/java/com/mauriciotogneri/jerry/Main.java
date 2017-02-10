package com.mauriciotogneri.jerry;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Main main = new Main();
        main.start();
    }

    private void start() throws Exception
    {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(Integer.parseInt(System.getenv("PORT")));
        jettyServer.setHandler(context);
        jettyServer.setErrorHandler(new CustomErrorHandler());

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, getClass().getPackage().getName());

        try
        {
            jettyServer.start();
            jettyServer.join();
        }
        finally
        {
            jettyServer.destroy();
        }
    }
}