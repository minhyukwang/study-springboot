package com.test.project.demo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.project.demo.vo.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserInfoResource {

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() throws IOException {
        //
        List<User> users = this.getUserDataList();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return ResponseEntity.ok().headers(headers).body(users);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam(value = "username") String username) throws IOException {
        //
        List<User> users = this.getUserDataList();
        User result = null;
        boolean resourceNotFound = true;
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                resourceNotFound = false;
                result = user;
                break;
            }
        }
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        ResponseEntity<User> responseEntity = ResponseEntity.ok().headers(headers).body(result);
        if (resourceNotFound) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
        }

        return responseEntity;
    }

    private List<User> getUserDataList() throws IOException {
        //
        ObjectMapper mapper = new ObjectMapper();
        User[] users = mapper.readValue(new File("data/input/user.json"), User[].class);
        return Arrays.stream(users).toList();
    }
}