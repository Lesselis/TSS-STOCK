package com.tsslesselis.stock.service;

import com.tsslesselis.stock.model.Usuario;
import com.tsslesselis.stock.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findAll()
                .stream()
                .filter(usuario -> usuario.getEmail().equals(email) && usuario.getSenha().equals(senha))
                .findFirst();
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.login();
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.validarEmail();
        usuario.validarSenha();
        return usuarioRepository.save(usuario);
    }

    public Usuario editar(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuarioExistente = usuarioOpt.get();
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setSenha(usuario.getSenha());
            usuarioExistente.setNivelAcesso(usuario.getNivelAcesso());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    public Usuario gerenciarAcesso(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.gerenciarAcesso();
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Usuario validarEmail(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.validarEmail();
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public Usuario validarSenha(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.validarSenha();
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> pesquisar(Long id) {
        return usuarioRepository.findById(id);
    }
}