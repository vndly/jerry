package com.mauriciotogneri.testapp.endpoints;

import com.mauriciotogneri.jerry.EndPoint;
import com.mauriciotogneri.jerry.Header;
import com.mauriciotogneri.testapp.model.Person;

import java.util.UUID;

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
    @Path("person")
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
    @Path("person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id)
    {
        Person person = new Person(id, "Bob", 35);

        return response(OK, person);
    }

    @GET
    @Path("person")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("limit") Integer limit,
                           @HeaderParam("token") String token)
    {
        Person[] persons = new Person[3];
        persons[0] = new Person(1L, "Bob", 35);
        persons[1] = new Person(2L, "Alice", 28);
        persons[2] = new Person(3L, "John", 44);

        return response(OK, persons);
    }

    @PUT
    @Path("person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") Long id,
                        Person person)
    {
        return response(OK, person, new Header("token", UUID.randomUUID().toString()));
    }

    @DELETE
    @Path("person/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id)
    {
        return response(NO_CONTENT);
    }
}