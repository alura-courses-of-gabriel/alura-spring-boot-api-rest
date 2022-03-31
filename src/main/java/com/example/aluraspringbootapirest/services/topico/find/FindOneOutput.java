package com.example.aluraspringbootapirest.services.topico.find;

import com.example.aluraspringbootapirest.modelo.Resposta;
import com.example.aluraspringbootapirest.modelo.StatusTopico;
import com.example.aluraspringbootapirest.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;

public record FindOneOutput(Long id, String titulo, String mensagem, String nomeDoCurso, LocalDateTime criacao,
                                 StatusTopico statusTopico, List<RespostaOutput> respostas) {
    public FindOneOutput(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCurso().getNome(), topico.getDataCriacao(), topico.getStatus(), topico.getRespostas().stream().map(RespostaOutput::new).toList());
    }

    public FindOneOutput(Long id, String titulo, String mensagem, String nomeDoCurso, LocalDateTime criacao, StatusTopico statusTopico, List<RespostaOutput> respostas) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.nomeDoCurso = nomeDoCurso;
        this.criacao = criacao;
        this.statusTopico = statusTopico;
        this.respostas = respostas;
    }
}

record RespostaOutput(Long id, String mensagem, LocalDateTime dataDeCriacao, String nomeDoAutor){
    public RespostaOutput (Resposta resposta){
        this(resposta.getId(), resposta.getMensagem(), resposta.getDataCriacao(), resposta.getAutor().getNome());
    }

    public RespostaOutput(Long id, String mensagem, LocalDateTime dataDeCriacao, String nomeDoAutor) {
        this.id = id;
        this.mensagem = mensagem;
        this.dataDeCriacao = dataDeCriacao;
        this.nomeDoAutor = nomeDoAutor;
    }
}
