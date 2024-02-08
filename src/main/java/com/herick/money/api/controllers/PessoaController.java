package com.herick.money.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herick.money.api.event.RecursoCriadoEvent;
import com.herick.money.api.model.Pessoa;
import com.herick.money.api.service.PessoaService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	private ResponseEntity<List<Pessoa>> buscarTodos() {
		List<Pessoa> pessoas = service.buscarTodos();
		return ResponseEntity.ok().body(pessoas);
	}

	@GetMapping("/{codigo}")
	private ResponseEntity<Pessoa> buscarPorId(@PathVariable Long codigo) {
		Pessoa pessoa = service.buscarPorId(codigo);
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping
	private ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa entity, HttpServletResponse response) {
		Pessoa pess = service.criar(entity);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, pess.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(pess);
	}

	@DeleteMapping("/{codigo}")
	private ResponseEntity<Void> remover(@PathVariable Long codigo) {
		service.delete(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{codigo}")
	private ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa entity) {
	    Pessoa pess = service.atualizar(codigo, entity);
	    return ResponseEntity.ok().body(pess);
	}
	
	@PatchMapping("/{codigo}/ativo")
	private ResponseEntity<Pessoa> atualizarAtivo(@PathVariable Long codigo, @Valid @RequestBody Boolean ativo) {
	    Pessoa pess = service.atualizarAtivo(codigo, ativo);
	    return ResponseEntity.ok().body(pess);
	}

}
