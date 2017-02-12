package com.mauriciotogneri.testapp.endpoints;

import com.mauriciotogneri.jerry.EndPoint;
import com.mauriciotogneri.jerry.Header;
import com.mauriciotogneri.testapp.model.Person;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;
import static javax.ws.rs.core.Response.Status.OK;

@Path("home")
public class Resource extends EndPoint
{
    @POST
    @Path("post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(Person person)
    {
        if ((person != null) && person.isValid())
        {
            return response(CREATED);
        }
        else
        {
            return response(BAD_REQUEST);
        }
    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id,
                        @QueryParam("limit") Integer limit,
                        @HeaderParam("token") String token)
    {
        Person person = new Person(id, "Bob", 35);

        return response(OK, person);
    }

    @PUT
    @Path("put/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Long id,
                        Person person)
    {
        return response(OK, person, new Header("Token", "1234567890"));
    }

    @DELETE
    @Path("post/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id)
    {
        return response(NO_CONTENT);
    }
}