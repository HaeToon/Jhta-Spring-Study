package com.heoth.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class User {
    @GetMapping("/sign-in")
    public String signIn(){
        return "user/sign-in";
    }
    @GetMapping("/sign-up")
    public String signUp(){
        return "user/sign-up";
    }
}