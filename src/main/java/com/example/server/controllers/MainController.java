package com.example.server.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/")
    String hello() {
        return "Hello World, Spring Boot!";
    }
}
