package com.mauriciotogneri.jerry.endpoints;

import com.mauriciotogneri.jerry.EndPoint;
import com.mauriciotogneri.jerry.model.Person;
import com.mauriciotogneri.jerry.model.Token;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("home")
public class Resource extends EndPoint
{
    @POST
    @Path("hello/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String helloWorld(@PathParam("id") Integer id,
                             @QueryParam("limit") Integer limit,
                             @HeaderParam("user-agent") String userAgent,
                             String body)
    {
        Token token = json(Token.class, body);

        String summary = String.format("id: %s - limit: %s - agent: %s - token: %s", id, limit, userAgent, token.token);

        //return error(NOT_FOUND);

        return json(new Person(1L, summary));
    }
}