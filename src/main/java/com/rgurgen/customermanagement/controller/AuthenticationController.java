package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.model.User;
import com.rgurgen.customermanagement.service.AuthenticationService;
import com.rgurgen.customermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/authentication")//pre-path
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("sign-up") //api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")//api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody User user) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }

    @GetMapping//api/authentication
    public ResponseEntity<?> signIn() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping(path = "{getByUserName}")//api/authentication/{getByUserName}
    public ResponseEntity<Optional> getByUserName(@PathVariable("getByUserName") String userName) {
        return ResponseEntity.ok(userService.findByUsername(userName));
    }
}
