package com.example.aluraspringbootapirest.services.topico.findall;

public record FindAllInput (String nomeDoCurso, Integer page, Integer itemsPerPage) {
    public FindAllInput(String nomeDoCurso, Integer page, Integer itemsPerPage) {
        this.nomeDoCurso = nomeDoCurso;
        this.page = page;
        this.itemsPerPage = itemsPerPage;
    }
}
