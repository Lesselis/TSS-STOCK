package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Notificacao;
import com.tsslesselis.stock.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao criar(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public void excluir(Long id) {
        notificacaoRepository.deleteById(id);
    }

    public List<Notificacao> listar() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> pesquisar(Long id) {
        return notificacaoRepository.findById(id);
    }

    public void enviarNotificacao(Notificacao notificacao) {
        notificacao.setStatus("Enviada");
        notificacaoRepository.save(notificacao);
    }
}
