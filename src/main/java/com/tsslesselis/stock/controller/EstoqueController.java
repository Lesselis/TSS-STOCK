package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Estoque;
import com.tsslesselis.stock.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/exportarCSV/{id}")
    public String exportarCSV(@PathVariable Long id) {
        return estoqueService.exportarCSV(id);
    }
    @GetMapping("/historico")
    public List<Estoque> gerarHistorico() {
        return estoqueService.gerarHistorico();
    }
    @GetMapping("/calcularValor/{id}")
    public BigDecimal calcularValorEstoque(@PathVariable Long id) {
        return estoqueService.calcularValorEstoque(id);
    }

    @PutMapping("/atualizar/{id}")
    public Estoque atualizarEstoque(@PathVariable Long id, @RequestBody Estoque estoqueAtualizado) {
        return estoqueService.atualizarEstoque(id, estoqueAtualizado);
    }
}