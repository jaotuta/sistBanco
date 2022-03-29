package com.letscode.modulobanco811.service.impl;

import com.letscode.modulobanco811.dtos.UsuarioRequest;
import com.letscode.modulobanco811.dtos.UsuarioResponse;
import com.letscode.modulobanco811.model.Usuario;
import com.letscode.modulobanco811.repository.UsuarioRepository;
import com.letscode.modulobanco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll(String nome) {
        if(nome != null){
            return usuarioRepository.findByNome(nome);
        }

        else return usuarioRepository.findAll();

    }

    @Override
    public Usuario create(UsuarioRequest usuarioRequest) {
        return usuarioRepository.save(new Usuario(usuarioRequest));
    }
    @Override
    public Usuario getById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
      return usuario;
    }

    @Override
    public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();

        usuarioRepository.delete(usuario);
    }


}
