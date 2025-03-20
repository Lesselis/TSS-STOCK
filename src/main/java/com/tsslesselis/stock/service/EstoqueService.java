package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Estoque;
import com.tsslesselis.stock.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public String exportarCSV(Long id) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        return String.join(",",
                String.valueOf(estoque.getId()),
                estoque.getMovimentacaoTipo(),
                estoque.getData().toString(),
                estoque.getProduto().getNome(),
                String.valueOf(estoque.getProduto().getEstoque())
        );
    }

    public List<Estoque> gerarHistorico() {
        return estoqueRepository.findAll();
    }

    public BigDecimal calcularValorEstoque(Long id) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível calcular o valor do estoque"));

        return estoque.getProduto().getPreco()
                .multiply(BigDecimal.valueOf(estoque.getProduto().getEstoque()));
    }

    public Estoque atualizarEstoque(Long id, Estoque estoqueAtualizado) {
        Estoque estoque = estoqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível atualizar o estoque"));

        estoque.setMovimentacaoTipo(estoqueAtualizado.getMovimentacaoTipo());
        estoque.setData(estoqueAtualizado.getData());

        return estoqueRepository.save(estoque);
    }
}
