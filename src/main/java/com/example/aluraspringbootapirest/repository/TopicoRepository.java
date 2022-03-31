package com.example.aluraspringbootapirest.repository;

import com.example.aluraspringbootapirest.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findAllByCursoNome(String cursoNome);
}
