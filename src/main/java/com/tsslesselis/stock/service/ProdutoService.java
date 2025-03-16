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
        produto.cadastrar();
        return produtoRepository.save(produto);
    }

    public Produto editar(Long id, Produto produto) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produtoExistente = produtoOpt.get();
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setDescricao(produto.getDescricao());
            produtoExistente.setPreco(produto.getPreco());
            produtoExistente.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            produtoExistente.setCategoria(produto.getCategoria());
            produtoExistente.setFornecedor(produto.getFornecedor());
            produto.editar();
            return produtoRepository.save(produtoExistente);
        }
        return null;
    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> pesquisar(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizarEstoque(Long id, int quantidade) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setQuantidadeEstoque(quantidade);
            produto.atualizarEstoque();
            return produtoRepository.save(produto);
        }
        return null;
    }
}