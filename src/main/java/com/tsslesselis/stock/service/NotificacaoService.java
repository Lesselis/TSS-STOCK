package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Notificacao;
import com.tsslesselis.stock.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao entrarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao definirLimites(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao enviarNotificacao(Long id) {
        Notificacao notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada"));
        notificacao.setStatus("Enviada");
        return notificacaoRepository.save(notificacao);
    }
}
