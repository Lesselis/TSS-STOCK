package com.tsslesselis.stock.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String senha;
    private String nivelAcesso;

    public void login() {

    }

    public void gerenciarAcesso() {

    }

    public boolean validarEmail() {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return this.email.matches(emailRegex);
    }

    public boolean validarSenha() {

        return this.senha != null && this.senha.length() >= 6;
    }

    public Usuario cadastrar(Usuario usuario) {
        if (usuario.validarEmail() && usuario.validarSenha()) {

            return usuario;
        } else {
            throw new IllegalArgumentException("Email ou senha inválidos");
        }
    }

    public Usuario editar(Long id, Usuario usuario) {
        return usuario;
    }

    public void excluir(Long id) {

    }

    public List<Usuario> listar() {
        return List.of();
    }

    public Optional<Usuario> pesquisar(Long id) {

        return Optional.empty();
    }
}