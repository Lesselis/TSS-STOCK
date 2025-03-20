package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Notificacao;
import com.tsslesselis.stock.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public void enviarEmail(List<String> destinatarios, String assunto, String mensagem) {
        logger.info("Iniciando envio de email");
        logger.debug("Destinatários: {}", destinatarios);
        logger.debug("Assunto: {}", assunto);
        logger.debug("Mensagem: {}", mensagem);

        Notificacao notificacao = new Notificacao();
        notificacao.setMensagem(mensagem);
        notificacao.setStatus("Pendente");

        notificacaoRepository.save(notificacao);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(destinatarios.toArray(new String[0]));
            message.setSubject(assunto);
            message.setText(mensagem);
            mailSender.send(message);
            notificacao.setStatus("Enviada");
            logger.info("Email enviado com sucesso");
        } catch (Exception e) {
            notificacao.setStatus("Erro: " + e.getMessage());
            logger.error("Erro ao enviar email: {}", e.getMessage(), e);
        } finally {
            notificacaoRepository.save(notificacao);
        }
    }
}