package com.example.aluraspringbootapirest.services.authenticate;

public record AuthenticateOutput(String token, String authenticationType){
    public AuthenticateOutput(String token) {
        this(token, "Bearer");
    }
}
