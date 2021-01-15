package com.gilsoncamargo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gilsoncamargo.model.Cidade;
import com.gilsoncamargo.model.Cliente;
import com.gilsoncamargo.repository.CidadeRepository;
import com.gilsoncamargo.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="API REST")
@CrossOrigin(origins="*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@ApiOperation(value="Retorna todos os clientes")
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@ApiOperation(value="Cadastra um cliente")
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		Cidade cidade = cidadeRepository.findById(cliente.getCidade().getId()).orElseThrow();
		
		cliente.setCidade(cidade);
		
		return clienteRepository.save(cliente);
	}
	
	@ApiOperation(value="Retorna um clinete por nome")
	@GetMapping("cliente/{nome}")
	public List<Cliente> buscarNome(@PathVariable String nome) {
		return clienteRepository.findByNome(nome);
	}
	
	@ApiOperation(value="Retorna um cliente por id")
	@GetMapping("cliente/{id}")
	public ResponseEntity<Cliente> buscarId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value="Altera um cliente")
	@PutMapping("cliente/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@ApiOperation(value="Deleta um cliente unico")
	@DeleteMapping("cliente/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
