package com.test.project.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.project.demo.vo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class UserInfoResource {


    @GetMapping("/users")
    public ResponseEntity<User> getUsers() throws IOException {

        // create a sample user object

        // create an instance of the ObjectMapper class
        ObjectMapper mapper = new ObjectMapper();

        // read the JSON file into a Java object
        // fixme: json file 경로 알맞게 지정 필요
        User[] users = mapper.readValue(new File("/data/input/user.json"), User[].class);

        // do something with the data
        for (User user : users) {
            System.out.println(user.getUserId() + " is " + user.getUsername());
        }
        // create a response entity with the user object as the body
        ResponseEntity<User> responseEntity = ResponseEntity.ok(users[0]);

        // add a header to the response entity
//        responseEntity = responseEntity.header("Content-Type", "application/json");

        // return the response entity
        return responseEntity;

    }
}