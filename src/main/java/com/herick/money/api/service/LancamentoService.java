package com.herick.money.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herick.money.api.model.Lancamento;
import com.herick.money.api.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	@Transactional(readOnly = true)
	public List<Lancamento> buscarTodos() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Lancamento> buscarPorId(Long codigo) {
		return repository.findById(codigo);
	}

	@Transactional
	public Lancamento criar(Lancamento entity) {
		return repository.save(entity);
	}

}
