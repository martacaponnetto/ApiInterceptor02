package com.example.Api_Interceptor.Middleware2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class BasicController {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Basic Controller!";
    }
}
