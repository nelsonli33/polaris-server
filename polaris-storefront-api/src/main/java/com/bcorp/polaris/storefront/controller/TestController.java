package com.bcorp.polaris.storefront.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    @GetMapping("/api/v1/test")
    public String authAccess()
    {
        return "Public Content.";
    }
}
