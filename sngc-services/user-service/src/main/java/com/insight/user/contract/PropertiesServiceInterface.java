package com.insight.user.contract;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PropertiesServiceInterface
{
    @PostMapping("properties/create")
    public Map<String, String> createProperties( @RequestBody Map<String, String> properties );
}
