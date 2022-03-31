package com.example.aluraspringbootapirest.services.topico.delete;

import com.example.aluraspringbootapirest.repository.TopicoRepository;
import com.example.aluraspringbootapirest.services.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Delete implements Service {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public Long execute(Object object) {
        Long id = (Long) object;
        topicoRepository.deleteById(id);
        return id;
    }
}
