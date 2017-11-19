package com.mauriciotogneri.jerry;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.servlet.ServletContainer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.TimeZone;

public class Jerry
{
    public final void start(int port, String packages) throws Exception
    {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(port);
        jettyServer.setHandler(context);
        jettyServer.setErrorHandler(new CustomErrorHandler());
        jettyServer.setRequestLog(this::onLog);

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

    private void onLog(Request request, Response response)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        log("<<< %s%n%n", dateFormat.format(new Date()));

        logRequest(request);

        log(">>> %s%n%n", dateFormat.format(new Date()));

        logResponse(request, response);
    }

    private void logRequest(Request request)
    {
        log("%s %s %s%n", request.getMethod(), request.getOriginalURI(), request.getHttpVersion().toString());

        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements())
        {
            String headerName = headerNames.nextElement();

            log("%s: %s%n", headerName, request.getHeader(headerName));
        }

        log("%n");
    }

    private void logResponse(Request request, Response response)
    {
        log("%s %s %s%n", request.getHttpVersion().toString(), response.getStatus(), response.getReason());

        for (String headerName : response.getHeaderNames())
        {
            log("%s: %s%n", headerName, response.getHeader(headerName));
        }

        log("%n");
    }

    private void log(String string, Object... arguments)
    {
        System.out.print(String.format(string, arguments));
        System.out.flush();
    }
}