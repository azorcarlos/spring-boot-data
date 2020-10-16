package com.azorcarlos.Data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.azorcarlos.Data.models.Evento;
import com.azorcarlos.Data.models.Pessoa;
import com.azorcarlos.Data.repository.EventoRepository;
import com.azorcarlos.Data.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EventoRepository eventoRepository;

	public PessoaController(PessoaRepository pessoaRepository, EventoRepository eventoRepository) {
		this.pessoaRepository = pessoaRepository;
		this.eventoRepository = eventoRepository;
	}
	
	@GetMapping("/{eventoId}")
	@ResponseBody
	public Page<Pessoa>findAll(@PathVariable Long eventoId, Pageable pageable){
		var evento = this.eventoRepository.findById(eventoId);
		Page<Pessoa>pessoas = this.pessoaRepository.findByEventoId(evento, pageable);
		
		return pessoas;
		
	}
	
	@PostMapping("/{eventId}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Pessoa create(@PathVariable Long eventId,  @RequestBody Pessoa pessoa) {
		var evento = this.eventoRepository.findById(eventId);
		if(evento.isPresent()) {
				pessoa.setEventoId(evento.get());
		}
		this.pessoaRepository.save(pessoa);
		
		return pessoa;
	}
	
	
	
	

}
