package com.tsslesselis.stock.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String movimentacaoTipo;
    private LocalDateTime data;
    private int quantidade;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

}
