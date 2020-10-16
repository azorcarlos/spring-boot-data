package com.azorcarlos.Data.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azorcarlos.Data.models.Evento;
import com.azorcarlos.Data.models.Pessoa;

@Repository
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {
	Page<Pessoa> findByEventoId(Optional<Evento> eventoId, Pageable pageable);

}
