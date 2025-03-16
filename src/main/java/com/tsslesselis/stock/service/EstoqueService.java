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

   public Estoque exportarCSV(Long id) {
       Optional<Estoque> estoqueOpt = estoqueRepository.findById(id);
       if (estoqueOpt.isPresent()) {
           Estoque estoque = estoqueOpt.get();
           estoque.exportarCSV();
           return estoqueRepository.save(estoque);
       }
       return null;
   }

   public Estoque gerarHistorico(Long id) {
       Optional<Estoque> estoqueOpt = estoqueRepository.findById(id);
       if (estoqueOpt.isPresent()) {
           Estoque estoque = estoqueOpt.get();
           estoque.gerarHistorico();
           return estoqueRepository.save(estoque);
       }
       return null;
   }

    public Estoque calcularValorEstoque(Long id) {
        Optional<Estoque> estoqueOpt = estoqueRepository.findById(id);
        if (estoqueOpt.isPresent()) {
            Estoque estoque = estoqueOpt.get();
            BigDecimal valorTotalEstoque = estoque.calcularValorTotal();
            return estoqueRepository.save(estoque);
        }
        return null;
    }

   public Estoque atualizarEstoque(Long id) {
       Optional<Estoque> estoqueOpt = estoqueRepository.findById(id);
       if (estoqueOpt.isPresent()) {
           Estoque estoque = estoqueOpt.get();
           estoque.atualizarEstoque();
           return estoqueRepository.save(estoque);
       }
       return null;
   }

   public void excluir(Long id) {
       estoqueRepository.deleteById(id);
   }

   public List<Estoque> listar() {
       return estoqueRepository.findAll();
   }

   public Optional<Estoque> pesquisar(Long id) {
       return estoqueRepository.findById(id);
   }
}
