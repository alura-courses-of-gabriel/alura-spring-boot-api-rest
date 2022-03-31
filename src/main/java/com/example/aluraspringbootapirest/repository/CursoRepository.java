package com.example.aluraspringbootapirest.repository;

import com.example.aluraspringbootapirest.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nome);
}
