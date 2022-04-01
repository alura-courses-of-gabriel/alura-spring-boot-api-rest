package com.example.aluraspringbootapirest.repository;

import com.example.aluraspringbootapirest.modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByCursoNome(String cursoNome, Pageable pageable);
}
