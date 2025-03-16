package com.tsslesselis.stock.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidadeEstoque;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    public void cadastrar() {

    }

    public void editar() {

    }

    public void excluir() {

    }

    public void listar() {

    }

    public void  pesquisar() {

    }

    public void atualizarEstoque() {
        
    }
}
