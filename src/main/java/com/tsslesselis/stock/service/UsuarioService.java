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
        return usuarioOpt.orElse(null); // Retorna null se não encontrar
    }

    public Usuario cadastrar(Usuario usuario) {
        if (!validarEmail(usuario.getEmail()) || !validarSenha(usuario.getSenha())) {
            throw new IllegalArgumentException("Email ou senha inválidos");
        }
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

    public void excluir(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> pesquisar(Long id) {
        return usuarioRepository.findById(id);
    }

    private boolean validarEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private boolean validarSenha(String senha) {
        return senha != null && senha.length() >= 6;
    }
}
