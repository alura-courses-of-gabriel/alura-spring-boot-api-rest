package com.example.aluraspringbootapirest.services.topico.insert;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record InsertInput(
        @NotNull @NotEmpty @Length(min = 5)
        String titulo,
        @NotNull @NotEmpty @Length(min = 10)
        String mensagem,
        @NotNull @NotEmpty
        String nomeDoCurso
) {
    public InsertInput(String titulo, String mensagem, String nomeDoCurso) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeDoCurso = nomeDoCurso;
    }
}
