package org.example.taskmanager.controller;

import org.example.taskmanager.service.AuthenticationService;
import org.example.taskmanager.security.JwtService;
import org.example.taskmanager.security.LoginResponse;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.LoginUserDto;
import org.example.taskmanager.service.dto.RegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final static Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }


    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registeredUser);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().token(jwtToken).expiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
