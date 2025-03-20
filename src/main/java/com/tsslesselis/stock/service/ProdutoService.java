package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Produto;
import com.tsslesselis.stock.model.Usuario;
import com.tsslesselis.stock.model.Usuario.NivelAcesso;
import com.tsslesselis.stock.repository.ProdutoRepository;
import com.tsslesselis.stock.repository.UsuarioRepository;
import com.tsslesselis.stock.repository.CategoriaRepository;
import com.tsslesselis.stock.repository.FornecedorRepository;
import com.tsslesselis.stock.repository.EstoqueRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Objects;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private EstoqueRepository EstoqueRepository;

    private static final int LIMIT_MINIMO_ESTOQUE = 10;

    private static final String ASSUNTO_EMAIL = "Alerta de estoque baixo";
    private static final String MENSAGEM_EMAIL = "O produto %s está com estoque baixo: %d unidades";

    public Produto cadastrar(Produto produto) {
        if (produto.getCategoria() == null || Objects.isNull(produto.getCategoria().getId()) ||
                !categoriaRepository.existsById(produto.getCategoria().getId())) {
            throw new RuntimeException("Categoria não encontrada.");
        }
        if (produto.getFornecedor() == null || Objects.isNull(produto.getFornecedor().getId()) ||
                !fornecedorRepository.existsById(produto.getFornecedor().getId())) {
            throw new RuntimeException("Fornecedor não encontrado.");
        }
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

    @Transactional
    public void excluir(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        EstoqueRepository.deleteByProdutoId(id);
        produtoRepository.deleteById(id);
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> pesquisar(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizarEstoque(Long id, int novaQuantidade) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setEstoque(novaQuantidade);

            if (produto.getEstoque() < LIMIT_MINIMO_ESTOQUE) {
                enviarEmailGerentes(produto);
            }
            return produtoRepository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    private void enviarEmailGerentes(Produto produto) {
        List<Usuario> gerentes = usuarioRepository.findAll().stream()
                .filter(usuario -> usuario.getNivelAcesso() == NivelAcesso.GERENTE)
                .collect(Collectors.toList());

        List<String> emailsGerentes = gerentes.stream()
                .map(Usuario::getEmail)
                .collect(Collectors.toList());

        if (!emailsGerentes.isEmpty()) {
            String mensagem = String.format(MENSAGEM_EMAIL, produto.getNome(), produto.getEstoque());
            emailService.enviarEmail(emailsGerentes, ASSUNTO_EMAIL, mensagem);
        }
    }
}
