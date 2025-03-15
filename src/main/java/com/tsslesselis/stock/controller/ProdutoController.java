package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Produto;
import com.tsslesselis.stock.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping
    public List<Produto> obterProdutos() {
        return produtoService.obterProdutos();
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable Long id) {
        return produtoService.obterProdutoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}
