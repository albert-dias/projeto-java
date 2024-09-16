package com.yazon.api.controller;

import com.yazon.api.entity.RestApiResponse;
import com.yazon.api.entity.UserEntity;
import com.yazon.api.service.TokenService;
import com.yazon.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "session")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/")
    public String createAuthenticationToken(@RequestBody String login, @RequestBody String password ) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password) );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        return jwtUtil.generateToken(userDetails);
    }

    @PostMapping("/new")
    public String registerUser(@RequestBody UserEntity authRequest) {

        return "Usuário registrado com sucesso";
    }

}
