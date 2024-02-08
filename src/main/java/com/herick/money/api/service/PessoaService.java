package com.herick.money.api.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.herick.money.api.model.Pessoa;
import com.herick.money.api.repository.PessoaRepository;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Transactional(readOnly = true)
    public List<Pessoa> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Pessoa buscarPorId(Long codigo) {
        return repository.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Erro ao encontrar o recurso pelo codigo: " + codigo));
    }

    @Transactional
    public Pessoa criar(Pessoa entity) {
        return repository.save(entity);
    }

    @Transactional
    public void delete(Long codigo) {
        repository.deleteById(codigo);
    }

    @Transactional
    public Pessoa atualizar(Long codigo, Pessoa entity) {
        Pessoa pess = getPessoaById(codigo);
        BeanUtils.copyProperties(entity, pess, "codigo");
        return repository.save(pess);
    }
    
    @Transactional
    public Pessoa atualizarAtivo(Long codigo, Boolean ativo) {
        Pessoa pess = getPessoaById(codigo);
        pess.setAtivo(ativo);
        return repository.save(pess);
    }

    private Pessoa getPessoaById(Long codigo) {
        return repository.getReferenceById(codigo);
    }
}
