package com.example.aluraspringbootapirest.controller;

public record AutenticarOutput(String token, String authenticationType){
    public AutenticarOutput(String token) {
        this(token, "Bearer");
    }
}
