package com.softvision.ims.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerDemo {

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "HEY....HELLO!";
    }
}
