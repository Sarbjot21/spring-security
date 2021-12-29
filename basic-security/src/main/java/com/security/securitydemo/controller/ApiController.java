package com.security.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/rest/api")
public class ApiController {

    @GetMapping("/get")
    public String welcomMessage(){
        return "Welcome";
    }
}
