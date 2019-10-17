package com.insight.user.model;

import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Properties
{
    private String id;
    private Map<String, String> properties;

    public Properties()
    {

    }

    public Properties( @JsonProperty( "Properties" ) Map<String, String> properties )
    {
        this.id = UUID.randomUUID().toString();
        this.properties = properties;
    }
}
