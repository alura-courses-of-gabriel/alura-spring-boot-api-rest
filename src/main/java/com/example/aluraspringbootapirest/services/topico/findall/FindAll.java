package com.example.aluraspringbootapirest.services.topico.findall;

import com.example.aluraspringbootapirest.modelo.Topico;
import com.example.aluraspringbootapirest.repository.TopicoRepository;
import com.example.aluraspringbootapirest.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class FindAll implements Service {

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public Page<FindAllOutput> execute(Object object) {
        FindAllInput input = (FindAllInput) object;

        Pageable pageable = PageRequest.of(input.page(), input.itemsPerPage());

        Page<Topico> page = getTopicosPagead(input, pageable);

        return page.map(FindAllOutput::new);
    }

    private Page<Topico> getTopicosPagead(FindAllInput input, Pageable pageable) {
        Page<Topico> page;

        if (input.nomeDoCurso() == null) {
            page = topicoRepository.findAll(pageable);
        }
        else {
            page = topicoRepository.findAllByCursoNome(input.nomeDoCurso(), pageable);
        }
        return page;
    }
}
