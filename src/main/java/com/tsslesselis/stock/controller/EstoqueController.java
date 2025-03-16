package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Estoque;
import com.tsslesselis.stock.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> listar() {
        return estoqueService.listar();
    }

    @GetMapping("/{id}")
    public Estoque pesquisar(@PathVariable Long id) {
        return estoqueService.pesquisar(id).orElse(null);
    }

    @PostMapping
    public Estoque atualizarEstoque(@RequestBody Estoque estoque) {
        return estoqueService.atualizarEstoque(estoque.getId());
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        estoqueService.excluir(id);
    }

    @PostMapping("/exportar/{id}")
    public Estoque exportarCSV(@PathVariable Long id) {
        return estoqueService.exportarCSV(id);
    }

    @PostMapping("/gerarHistorico/{id}")
    public Estoque gerarHistorico(@PathVariable Long id) {
        return estoqueService.gerarHistorico(id);
    }

    @PostMapping("/calcularValor/{id}")
    public Estoque calcularValorEstoque(@PathVariable Long id) {
        return estoqueService.calcularValorEstoque(id);
    }
}