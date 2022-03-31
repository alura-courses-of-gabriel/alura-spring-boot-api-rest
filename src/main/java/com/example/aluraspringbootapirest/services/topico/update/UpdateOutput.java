package com.example.aluraspringbootapirest.services.topico.update;

import com.example.aluraspringbootapirest.modelo.Topico;

public record UpdateOutput(Long id, String titulo, String mensagem, String nomeDoCurso) {
    public UpdateOutput(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),topico.getCurso().getNome());
    }

    public UpdateOutput(Long id, String titulo, String mensagem, String nomeDoCurso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeDoCurso = nomeDoCurso;
    }
}
