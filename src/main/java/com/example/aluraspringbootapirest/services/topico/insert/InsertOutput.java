package com.example.aluraspringbootapirest.services.topico.insert;

import com.example.aluraspringbootapirest.modelo.Topico;

public record InsertOutput(Long id, String titulo, String mensagem, String nomeDoCurso) {
    public InsertOutput(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),topico.getCurso().getNome());
    }

    public InsertOutput(Long id, String titulo, String mensagem, String nomeDoCurso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeDoCurso = nomeDoCurso;
    }
}
