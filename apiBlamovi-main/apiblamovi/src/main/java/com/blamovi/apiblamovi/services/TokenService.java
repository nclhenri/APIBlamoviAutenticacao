package com.blamovi.apiblamovi.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.blamovi.apiblamovi.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    private final Algorithm algoritmo = Algorithm.HMAC256(secret);

    public String gerarToken(UsuarioModel usuario){
        try{
            String token = JWT.create()
                    .withIssuer("api-blamovi")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(gerarValidadeToken())
                    .sign(algoritmo);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao criar o token!");
        }
    }

    public String validarToken(String token){
        try{
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("api=blamovi")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTCreationException exception){
            throw new RuntimeException(exception);
        }
    }

    private Instant gerarValidadeToken(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-o3:00"));
    }
}
