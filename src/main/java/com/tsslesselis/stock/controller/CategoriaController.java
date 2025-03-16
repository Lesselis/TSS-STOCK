package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Categoria;
import com.tsslesselis.stock.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria cadastrar(@RequestBody Categoria categoria) {
        return categoriaService.cadastrar(categoria);
    }

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public Categoria pesquisar(@PathVariable Long id) {
        return categoriaService.pesquisar(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        categoriaService.excluir(id);
    }

    @GetMapping("/filtrar")
    public List<Categoria> filtrarPorNome(@RequestParam String nome) {
        return categoriaService.filtrarPorNome(nome);
    }
}