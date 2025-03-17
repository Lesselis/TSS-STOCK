package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Produto;
import com.tsslesselis.stock.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto editar(Long id, Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            if (produtoAtualizado.getNome() != null) produto.setNome(produtoAtualizado.getNome());
            if (produtoAtualizado.getDescricao() != null) produto.setDescricao(produtoAtualizado.getDescricao());
            if (produtoAtualizado.getPreco() != null) produto.setPreco(produtoAtualizado.getPreco());
            if (produtoAtualizado.getEstoque() > 0) produto.setEstoque(produtoAtualizado.getEstoque());
            if (produtoAtualizado.getCategoria() != null) produto.setCategoria(produtoAtualizado.getCategoria());
            if (produtoAtualizado.getFornecedor() != null) produto.setFornecedor(produtoAtualizado.getFornecedor());

            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void excluir(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> pesquisar(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizarEstoque(Long id, int quantidade) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setEstoque(quantidade);
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
