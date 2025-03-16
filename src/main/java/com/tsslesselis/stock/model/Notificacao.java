package com.tsslesselis.stock.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String mensagem;
    private String status;

    public void entrarNotificacao() {
        this.status = "ENTROU";
    }

    public void definirLimites() {

    }

    public void enviarNotificacao() {
        this.status = "ENVIADA";
    }
}
