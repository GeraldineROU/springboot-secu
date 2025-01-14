package com.example.kara2.controller;

import com.example.kara2.dto.TokenDTO;
import com.example.kara2.dto.UserCredentialsDTO;
import com.example.kara2.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil = new JWTUtil();

    @PostMapping("/signup")
    public String signup(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        return "success";
    }

    @PostMapping("/login")
    public TokenDTO login(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        System.out.println(userCredentialsDTO);
        final Authentication authenticate = authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        userCredentialsDTO.username(), userCredentialsDTO.password()
                )
            );
        String token = jwtUtil.generateToken(userCredentialsDTO.username());
        return new TokenDTO(token, userCredentialsDTO.username());
    }
}
