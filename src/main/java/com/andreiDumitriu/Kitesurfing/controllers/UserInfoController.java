package com.andreiDumitriu.Kitesurfing.controllers;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserInfoController {

    @GetMapping("/users/me")
    public Object currentUser(Authentication auth){
        return auth.getName();
    }

}
