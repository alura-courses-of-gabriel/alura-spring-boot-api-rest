package com.example.aluraspringbootapirest.services.topico.findall;

import com.example.aluraspringbootapirest.modelo.Topico;
import com.example.aluraspringbootapirest.repository.TopicoRepository;
import com.example.aluraspringbootapirest.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class FindAll implements Service {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public List<FindAllOutput> execute(Object object) {
        String nome = (String) object;

        List<Topico> topicos = getTopicos(nome);

        return topicos.stream().map(FindAllOutput::new).toList();
    }

    private List<Topico> getTopicos(String nome) {
        List<Topico> topicos;

        if (nome == null) topicos = topicoRepository.findAll();
        else topicos = topicoRepository.findAllByCursoNome(nome);
        return topicos;
    }
}
