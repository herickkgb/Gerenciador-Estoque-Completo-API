package com.herick.money.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herick.money.api.event.RecursoCriadoEvent;
import com.herick.money.api.model.Categoria;
import com.herick.money.api.service.CategoriaService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService servicie;
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	private List<Categoria> listar() {
		return servicie.listar();
	}

	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria entity, HttpServletResponse response) {
		Categoria cat = servicie.criar(entity);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cat.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(cat);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Long codigo) {
		Categoria categoria = servicie.buscarPorId(codigo);
		return ResponseEntity.ok().body(categoria);
	}
}
