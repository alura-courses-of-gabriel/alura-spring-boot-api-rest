package com.example.aluraspringbootapirest.controller;

import com.example.aluraspringbootapirest.services.authenticate.AuthenticateOutput;
import com.example.aluraspringbootapirest.services.authenticate.Authenticate;
import com.example.aluraspringbootapirest.services.authenticate.AuthenticateInput;
import com.example.aluraspringbootapirest.services.tokenmanagement.GenerateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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
    private GenerateToken generateToken;

    @Autowired
    private Authenticate authenticate;

    @PostMapping
    public ResponseEntity<AuthenticateOutput> autenticar(@RequestBody @Valid AuthenticateInput data) {
        try {
            AuthenticateOutput output = (AuthenticateOutput) this.authenticate.execute(data);
            return ResponseEntity.ok(output);
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
