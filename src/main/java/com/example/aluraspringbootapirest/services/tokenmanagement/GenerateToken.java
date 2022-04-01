package com.example.aluraspringbootapirest.services.tokenmanagement;

import com.example.aluraspringbootapirest.modelo.Usuario;
import com.example.aluraspringbootapirest.services.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import java.util.Date;

@org.springframework.stereotype.Service
public class GenerateToken implements Service {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret;

    @Override
    public Object execute(Object object) {
        Authentication authenticationManager = (Authentication) object;
        Usuario usuario = (Usuario) authenticationManager.getPrincipal();
        Date date = new Date();
        Date dataExpiracao = new Date(date.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API do Fórum da Alura")
                .setSubject(usuario.getId().toString())
                .setIssuedAt(date)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}
