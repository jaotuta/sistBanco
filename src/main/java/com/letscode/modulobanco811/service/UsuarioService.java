package com.letscode.modulobanco811.service;

import com.letscode.modulobanco811.dtos.UsuarioRequest;
import com.letscode.modulobanco811.dtos.UsuarioResponse;
import com.letscode.modulobanco811.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {

    List<Usuario> getAll(String nome);
    Usuario create(UsuarioRequest usuarioRequest);
    Usuario getById(Integer id);
    Usuario update(UsuarioRequest usuarioRequest, Integer id);
    void delete(Integer id);

}
