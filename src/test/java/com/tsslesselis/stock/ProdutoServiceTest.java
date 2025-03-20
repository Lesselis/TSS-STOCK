package com.tsslesselis.stock;

import com.tsslesselis.stock.model.Produto;
import com.tsslesselis.stock.service.ProdutoService;
import com.tsslesselis.stock.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

public class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    private Produto produto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setPreco(BigDecimal.valueOf(100.00));
        produto.setEstoque(10);
    }

    @Test
    public void testCadastrarProduto() {
        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

        Produto produtoSalvo = produtoService.cadastrar(produto);

        assertNotNull(produtoSalvo);
        assertEquals("Produto Teste", produtoSalvo.getNome());
        verify(produtoRepository, times(1)).save(any(Produto.class));
    }

    @Test
    public void testExcluirProduto() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));
        doNothing().when(produtoRepository).deleteById(1L);

        produtoService.excluir(1L);

        verify(produtoRepository, times(1)).deleteById(1L);
    }

}
