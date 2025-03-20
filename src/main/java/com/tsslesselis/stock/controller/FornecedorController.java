package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Fornecedor;
import com.tsslesselis.stock.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public Fornecedor cadastrar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.cadastrar(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> listar() {
        return fornecedorService.listar();
    }

    @GetMapping("/{id}")
    public Fornecedor pesquisar(@PathVariable Long id) {
        return fornecedorService.pesquisar(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        fornecedorService.excluir(id);
    }
}