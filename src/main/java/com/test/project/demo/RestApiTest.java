package com.test.project.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class RestApiTest {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    String apiTest() {
        return "{\"test\" : \"sucess\"}";
    }
}