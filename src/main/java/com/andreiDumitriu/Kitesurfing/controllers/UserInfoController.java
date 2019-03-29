package com.andreiDumitriu.Kitesurfing.controllers;


import com.andreiDumitriu.Kitesurfing.repositories.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
public class UserInfoController {

    private final UserRepository userRepo;
    UserInfoController(UserRepository repository){
        this.userRepo = repository;
    }


    @GetMapping("/users/me")
    public Object currentUser(Authentication auth){

        return auth.getName();
    }

    @GetMapping("/favorite/{id}")
    public String insertFavorite(@PathVariable("id") Long id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            Long userID=userRepo.getUserIdByName(currentUserName);

            userRepo.insertFavorite(id, userID);
        }

        return "Succes!";
    }



}
