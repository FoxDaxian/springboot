package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController{
    @RequestMapping(path = "/helloWorld")
    public String hello() {
        return "你好，世界";
    }
}