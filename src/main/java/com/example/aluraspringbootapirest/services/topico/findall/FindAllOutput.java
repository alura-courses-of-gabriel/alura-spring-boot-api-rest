package com.example.aluraspringbootapirest.services.topico.findall;

import com.example.aluraspringbootapirest.modelo.Topico;

public record FindAllOutput(Long id, String titulo, String mensagem, String nomeDoCurso){
    public FindAllOutput(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(),topico.getCurso().getNome());
    }

    public FindAllOutput(Long id, String titulo, String mensagem, String nomeDoCurso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeDoCurso = nomeDoCurso;
    }
}
