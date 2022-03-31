package com.example.aluraspringbootapirest.services.topico.update;

import java.util.Objects;

public final class UpdateInput {
    private Long id;
    private final String titulo;
    private final String mensagem;

    public UpdateInput(Long id, String titulo, String mensagem) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    public UpdateInput(String titulo, String mensagem) {
        this(null, titulo, mensagem);
    }

    public void id(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }

    public String titulo() {
        return titulo;
    }

    public String mensagem() {
        return mensagem;
    }

}
