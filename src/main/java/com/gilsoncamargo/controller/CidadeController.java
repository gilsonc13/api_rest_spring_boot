package com.gilsoncamargo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsoncamargo.model.Cidade;
import com.gilsoncamargo.repository.CidadeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value="API REST")
@CrossOrigin(origins="*")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
		
	@ApiOperation(value="Cadastra uma nova cidade")
	@PostMapping("/cidades")
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	@ApiOperation(value="Retorna todas as cidades")
	@GetMapping("/cidades")
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma cidade pelo nome")
	@GetMapping("cidade/{nome}")
	public List<Cidade> buscarNome(@PathVariable String nome) {
		return cidadeRepository.findByNome(nome);
	}
	
	@ApiOperation(value="Retorna a lista de cidades por estados")
	@GetMapping("/estado/{estado}")
	public List<Cidade> buscarEstado(@PathVariable String estado) {
		return cidadeRepository.findByEstado(estado);
	}
		
}
