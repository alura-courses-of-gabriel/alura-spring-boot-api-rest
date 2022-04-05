package com.example.aluraspringbootapirest.repository;

import com.example.aluraspringbootapirest.modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Curso curso;

    @BeforeEach
    public void beforeAll() {
        this.curso = new Curso("Programação", "Exatas");
        this.entityManager.persist(this.curso);
    }

    @Test
    public void deveCarregarUmCursoAoBuscarPeloNome(){
        Curso cursoRetornado = cursoRepository.findByNome(this.curso.getNome());

        Assertions.assertNotNull(cursoRetornado);
        Assertions.assertEquals(this.curso.getNome(), cursoRetornado.getNome());

    }

    @Test
    public void naoDeveCarregarUmCursoAoBuscarPeloNome(){
        String nomeDoCurso = "JPA";

        Curso curso = cursoRepository.findByNome(nomeDoCurso);

        Assertions.assertNull(curso);

    }

}