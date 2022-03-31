package com.example.aluraspringbootapirest.services.topico.find;

import com.example.aluraspringbootapirest.modelo.Topico;
import com.example.aluraspringbootapirest.repository.TopicoRepository;
import com.example.aluraspringbootapirest.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class FindOne implements Service {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public FindOneOutput execute(Object object) {
        Long id = (Long) object;
        Topico topico = topicoRepository.getById(id);
        return new FindOneOutput(topico);
    }
}
