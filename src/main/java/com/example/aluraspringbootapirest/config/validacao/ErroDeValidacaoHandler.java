package com.example.aluraspringbootapirest.config.validacao;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErroDeValidacaoHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<MethodArgumentNotValidExceptionDTO> handle(MethodArgumentNotValidException exception) {
        List<FieldError> erros = exception.getBindingResult().getFieldErrors();
        return erros.stream().map(MethodArgumentNotValidExceptionDTO::new).toList();
    }
}
