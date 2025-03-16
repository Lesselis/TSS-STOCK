package com.tsslesselis.stock.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    public void cadastrar() {

    }

    public void listar() {

    }

    public void filtrarPorNome() {

    }

}
