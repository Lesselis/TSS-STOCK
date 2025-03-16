package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Notificacao;
import com.tsslesselis.stock.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/entrar")
    public Notificacao entrarNotificacao(@RequestBody Notificacao notificacao) {
        return notificacaoService.entrarNotificacao(notificacao);
    }

    @PostMapping("/definirLimites")
    public Notificacao definirLimites(@RequestBody Notificacao notificacao) {
        return notificacaoService.definirLimites(notificacao);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        notificacaoService.excluir(id);
    }

    @GetMapping
    public List<Notificacao> listar() {
        return notificacaoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Notificacao> pesquisar(@PathVariable Long id) {
        return notificacaoService.pesquisar(id);
    }

    @PostMapping("/enviar/{id}")
    public Notificacao enviarNotificacao(@PathVariable Long id) {
        return notificacaoService.enviarNotificacao(id);
    }
}