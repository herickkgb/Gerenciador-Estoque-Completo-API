package com.herick.money.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herick.money.api.model.Categoria;
import com.herick.money.api.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;

	@Transactional(readOnly = true)
	public List<Categoria> listar() {
		return repository.findAll();
	}

	@Transactional
	public Categoria criar(Categoria entity) {
		return repository.save(entity);
	}

	@Transactional(readOnly = true)
	public Categoria buscarPorId(Long codigo) {
		Categoria cat = repository.findById(codigo)
				.orElseThrow(() -> new RuntimeException("Erro ao encontrar o recurso pelo codigo: " + codigo));
		return cat;
	}
}
