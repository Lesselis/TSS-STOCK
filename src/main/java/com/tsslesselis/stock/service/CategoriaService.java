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
       List<Categoria> categorias = categoriaRepository.findAll();
       for (Categoria categoria : categorias) {
           categoria.listar();
       }
       return categorias;
   }

   public Optional <Categoria> pesquisar(Long id) {
         return categoriaRepository.findById(id);
   }

   public List<Categoria> filtrarPorNome( String nome) {
       List<Categoria> categorias = categoriaRepository.findAll();
       categorias.removeIf(categoria -> !categoria.getNome().equals(nome));
       for (Categoria categoria : categorias) {
           categoria.filtrarPorNome();
       }
       return categorias;
   }

   public void excluir(Long id) {
         categoriaRepository.deleteById(id);
   }
}
