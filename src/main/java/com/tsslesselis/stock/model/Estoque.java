package com.tsslesselis.stock.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;


@Data
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String movimentacaoTipo;
    private Date data;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public void exportarCSV() {

    }

    public void gerarHistorico() {

    }

    public BigDecimal calcularValorTotal() {
        return produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidadeEstoque()));
    }

    public void atualizarEstoque() {

    }
}
