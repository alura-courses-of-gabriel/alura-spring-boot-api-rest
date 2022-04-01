package com.example.aluraspringbootapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<AutenticarOutput> autenticar(@RequestBody @Valid LoginData data) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        try {
            Authentication autenticador = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            String token = tokenService.gerarToken(autenticador);
            return ResponseEntity.ok(new AutenticarOutput(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
