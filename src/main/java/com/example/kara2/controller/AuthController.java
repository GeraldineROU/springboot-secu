package com.example.kara2.controller;

import com.example.kara2.dto.TokenDTO;
import com.example.kara2.dto.UserCredentialsDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/signup")
    public String signup(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        return "success";
    }

    @PostMapping("/login")
    public TokenDTO login(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        return new TokenDTO("token", userCredentialsDTO.userName());
    }
}
