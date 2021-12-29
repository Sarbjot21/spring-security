package com.security.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/noauth/api")
public class ApiControllerNoAuth {

    @GetMapping("/get")
    public String welcomMessage(){
        return "Welcome No Auth";
    }
}
