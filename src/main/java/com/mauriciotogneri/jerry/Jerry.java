package com.mauriciotogneri.jerry;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
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
    public enum Mode
    {
        REMOTE,
        LOCAL
    }

    public final void start(int port, Mode mode, String packages) throws Exception
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
        server.setErrorHandler(new CustomErrorHandler());
        server.setRequestLog(this::onLog);

        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitParameter(ServerProperties.PROVIDER_PACKAGES, packages);

        try
        {
            server.start();
            server.join();
        }
        finally
        {
            server.destroy();
        }
    }

    public final void start(int port, Mode mode, Package packages) throws Exception
    {
        start(port, mode, packages.getName());
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