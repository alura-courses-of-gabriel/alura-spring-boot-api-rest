package com.example.aluraspringbootapirest.services.topico.findall;

import org.springframework.data.domain.Pageable;

public record FindAllInput (String nomeDoCurso, Pageable pageable) {

}
