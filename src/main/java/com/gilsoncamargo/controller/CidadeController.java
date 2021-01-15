package com.gilsoncamargo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsoncamargo.model.Cidade;
import com.gilsoncamargo.repository.CidadeRepository;


@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/{nome}")
	public List<Cidade> buscarNome(@PathVariable String nome) {
		return cidadeRepository.findByNome(nome);
	}
	
	@GetMapping("/estado/{estado}")
	public List<Cidade> buscarEstado(@PathVariable String estado) {
		return cidadeRepository.findByEstado(estado);
	}
		
}
