package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Fornecedor;
import com.tsslesselis.stock.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor cadastrar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listar() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> pesquisar(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void excluir(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
