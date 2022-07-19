package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/internal")//pre-path
public class InternalApiController {

    private final UserService userService;

    public InternalApiController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("make-admin/{username}") //api/internal/make-admin/{username}
    public ResponseEntity<?> makeAdmin(@PathVariable String username) {
        userService.makeAdmin(username);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
