package com.tsslesselis.stock.controller;

import com.tsslesselis.stock.model.Usuario;
import com.tsslesselis.stock.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha) {
        return usuarioService.login(email, senha);
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioService.cadastrar(usuario);
    }

    @PutMapping("/editar/{id}")
    public Usuario editar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.editar(id, usuario);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario pesquisar(@PathVariable Long id) {
        return usuarioService.pesquisar(id).orElse(null);
    }

    @PostMapping("/gerenciarAcesso/{id}")
    public Usuario gerenciarAcesso(@PathVariable Long id) {
        return usuarioService.gerenciarAcesso(id);
    }

    @PostMapping("/validarEmail/{id}")
    public Usuario validarEmail(@PathVariable Long id) {
        return usuarioService.validarEmail(id);
    }

    @PostMapping("/validarSenha/{id}")
    public Usuario validarSenha(@PathVariable Long id) {
        return usuarioService.validarSenha(id);
    }
}