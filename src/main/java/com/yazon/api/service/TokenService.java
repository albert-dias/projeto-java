package com.yazon.api.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yazon.api.entity.RestApiResponse;
import com.yazon.api.entity.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(UserEntity user) {
        return JWT.create()
                .withIssuer("Produto")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("alterar aqui"));
    }
}
