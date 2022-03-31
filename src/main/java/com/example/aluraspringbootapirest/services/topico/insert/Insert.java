package com.example.aluraspringbootapirest.services.topico.insert;

import com.example.aluraspringbootapirest.modelo.Topico;
import com.example.aluraspringbootapirest.repository.CursoRepository;
import com.example.aluraspringbootapirest.repository.TopicoRepository;
import com.example.aluraspringbootapirest.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Insert implements Service {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public InsertOutput execute(Object object) {
        InsertInput input = (InsertInput) object;

        Topico topico = new Topico(input.titulo(), input.mensagem(), cursoRepository.findByNome(input.nomeDoCurso()));

        topico = topicoRepository.save(topico);

        return new InsertOutput(topico);
    }
}
