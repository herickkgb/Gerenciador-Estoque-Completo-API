package com.herick.money.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herick.money.api.event.RecursoCriadoEvent;
import com.herick.money.api.model.Lancamento;
import com.herick.money.api.service.LancamentoService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService service;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	private ResponseEntity<List<Lancamento>> buscarTodos() {
		List<Lancamento> lancamentos = service.buscarTodos();
		return ResponseEntity.ok().body(lancamentos);
	}

	@GetMapping("/{codigo}")
	private Lancamento buscarPorId(@PathVariable Long codigo) {
		return service.buscarPorId(codigo)
				.orElseThrow(() -> new RuntimeException("Nenhum recurso encontrado para o ID: " + codigo));
	}

	@PostMapping
	private ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento entity, HttpServletResponse response) {
		Lancamento lanc = service.criar(entity);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lanc.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lanc);
	}

}
