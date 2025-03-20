package com.tsslesselis.stock.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private NivelAcesso nivelAcesso;

    public enum NivelAcesso {
        ADMIN,
        OPERADOR,
        GERENTE
    }

}