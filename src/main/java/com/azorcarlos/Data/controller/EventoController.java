package com.azorcarlos.Data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azorcarlos.Data.models.Evento;
import com.azorcarlos.Data.repository.EventoRepository;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	
	@Autowired
	private EventoRepository eventoRepository;
	
	public EventoController (EventoRepository enventoEventoRepository) {
		this.eventoRepository = enventoEventoRepository;
	}
	
	@GetMapping
	public Page<Evento>findAll(Pageable pageable){
		return (Page<Evento>) this.eventoRepository.findAll(pageable);
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Evento create(@RequestBody Evento evento) {
		
		return this.eventoRepository.save(evento);
		
	
	}
	
	//public Teste
	//https://stackoverflow.com/questions/2110809/use-of-entitymanager-createnativequeryquery-foo-class/2110860#2110860
}
