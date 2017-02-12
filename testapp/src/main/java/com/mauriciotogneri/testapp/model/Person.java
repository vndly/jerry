package com.mauriciotogneri.testapp.model;

public class Person
{
    public final Long id;
    public final String name;
    public final Integer age;

    public Person(Long id, String name, Integer age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Boolean isValid()
    {
        return (id != null) && (name != null) && (age != null);
    }
}