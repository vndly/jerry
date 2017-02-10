package com.mauriciotogneri.jerry.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("home")
public class Resource
{
    @GET
    @Path("hello/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld(@PathParam("id") int id)
    {
        return "Hello, world! " + id;
    }
}