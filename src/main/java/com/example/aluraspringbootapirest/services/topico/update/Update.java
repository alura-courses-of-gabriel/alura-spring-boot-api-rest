package com.example.aluraspringbootapirest.services.topico.update;

import com.example.aluraspringbootapirest.modelo.Topico;
import com.example.aluraspringbootapirest.repository.TopicoRepository;
import com.example.aluraspringbootapirest.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@org.springframework.stereotype.Service
public class Update implements Service {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    @Transactional
    public UpdateOutput execute(Object object) {
        UpdateInput input = (UpdateInput) object;
        Topico topico = topicoRepository.getById(input.id());
        topico.setTitulo(input.titulo());
        topico.setMensagem(input.mensagem());
        return new UpdateOutput(topico);
    }
}
