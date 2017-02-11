package com.mauriciotogneri.jerry;

import com.mauriciotogneri.jerry.kernel.CustomErrorHandler;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

public class Jerry
{
    public static void main(String[] args) throws Exception
    {
        int port = Integer.parseInt(System.getenv("PORT"));
        String packages = Jerry.class.getPackage().getName();

        Jerry jerry = new Jerry();
        jerry.start(port, packages);
    }

    private void start(int port, String packages) throws Exception
    {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(port);
        jettyServer.setHandler(context);
        jettyServer.setErrorHandler(new CustomErrorHandler());

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, packages);

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