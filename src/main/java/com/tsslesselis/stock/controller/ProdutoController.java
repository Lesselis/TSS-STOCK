package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Produto;
import com.tsslesselis.stock.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/cadastrar")
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoService.cadastrar(produto);
    }

    @PutMapping("/editar/{id}")
    public Produto editar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.editar(id, produto);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        produtoService.excluir(id);
    }

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Produto> pesquisar(@PathVariable Long id) {
        return produtoService.pesquisar(id);
    }

    @PutMapping("/atualizarEstoque/{id}")
    public Produto atualizarEstoque(@PathVariable Long id, @RequestParam int quantidade) {
        return produtoService.atualizarEstoque(id, quantidade);
    }
}