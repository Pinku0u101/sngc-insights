package com.sngc.insights;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource
{
    @GetMapping("users")
    public User getUser()
    {
        return new User("Priyanka");
    }

}
