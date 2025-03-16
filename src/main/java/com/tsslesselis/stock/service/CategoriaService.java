package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Categoria;
import com.tsslesselis.stock.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria cadastrar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> pesquisar(Long id) {
        return categoriaRepository.findById(id);
    }

    public List<Categoria> filtrarPorNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }

    public void excluir(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Categoria não encontrada.");
        }
    }
}
