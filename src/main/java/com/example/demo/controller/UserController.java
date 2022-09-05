package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.model.Credential;
import com.example.demo.security.model.User;
import com.example.demo.security.service.SecurityService;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    
    private final SecurityService securityService;
    
    @GetMapping("/getUser")
    public ResponseEntity<?> getUserDetails() {
        User user = securityService.getUser();
        return ResponseEntity.ok(user);
    }
    @GetMapping("/getCredential")
    public ResponseEntity<?> getCredential() {
        Credential credential = securityService.getCredentials();
        return ResponseEntity.ok(credential);
    }
}
