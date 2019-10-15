package com.sngc.insights;

import com.fasterxml.jackson.annotation.JsonCreator;

public class User
{
    private String name;

    @JsonCreator
    public User( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
