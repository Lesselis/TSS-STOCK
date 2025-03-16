package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Estoque;
import com.tsslesselis.stock.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> listar() {
        return estoqueRepository.findAll();
    }

    public Optional<Estoque> pesquisar(Long id) {
        return estoqueRepository.findById(id);
    }

    public BigDecimal calcularValorEstoque(Long id) {
        Estoque estoque = estoqueRepository.findById(id).orElse(null);
        if (estoque != null) {
            return estoque.getProduto().getPreco()
                    .multiply(BigDecimal.valueOf(estoque.getProduto().getEstoque()));
        }
        return BigDecimal.ZERO;
    }

    public void excluir(Long id) {
        if (estoqueRepository.existsById(id)) {
            estoqueRepository.deleteById(id);
        } else {
            throw new RuntimeException("Estoque com ID " + id + " não encontrado.");
        }
    }
}
