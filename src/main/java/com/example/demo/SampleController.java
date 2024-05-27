package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class SampleController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
