package com.mauriciotogneri.testapp.providers;

import com.mauriciotogneri.jerry.EntityProvider;
import com.mauriciotogneri.testapp.model.Person;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class PersonProvider extends EntityProvider<Person>
{
    public PersonProvider()
    {
        super(Person.class);
    }
}