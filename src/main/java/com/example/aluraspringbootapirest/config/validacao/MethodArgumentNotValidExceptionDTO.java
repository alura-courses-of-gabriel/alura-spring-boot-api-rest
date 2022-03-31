package com.example.aluraspringbootapirest.config.validacao;

import org.springframework.validation.FieldError;

public record MethodArgumentNotValidExceptionDTO(String campo, String erro) {

    public MethodArgumentNotValidExceptionDTO(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }

    public MethodArgumentNotValidExceptionDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
