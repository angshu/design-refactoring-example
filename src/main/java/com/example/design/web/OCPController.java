package com.example.design.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OCPController  {
    @GetMapping("/")
    public String home() {
        return "Greetings from Design Training Session!";
    }
}
