package com.letscode.modulobanco811.controllers;

import com.letscode.modulobanco811.dtos.UsuarioRequest;
import com.letscode.modulobanco811.model.Usuario;
import com.letscode.modulobanco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public Page<Usuario> getAll(@RequestParam(required = false) String nome,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "10") int size
    ) {

        return usuarioService.getAll(nome, page, size);
    }

    @PostMapping
    public Usuario create(@RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Integer id) {
        return usuarioService.getById(id);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.update(usuarioRequest, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        usuarioService.delete(id);
    }



}
