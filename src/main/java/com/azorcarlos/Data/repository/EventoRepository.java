package com.azorcarlos.Data.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.azorcarlos.Data.models.Evento;


public interface EventoRepository extends PagingAndSortingRepository<Evento, Long> {

}
