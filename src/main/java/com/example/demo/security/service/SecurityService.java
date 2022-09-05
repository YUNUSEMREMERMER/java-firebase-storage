package com.example.demo.security.service;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.security.model.Credential;
import com.example.demo.security.model.User;


public interface SecurityService {
    User getUser();
    Credential getCredentials();
    String getBearerToken(HttpServletRequest request);
}
