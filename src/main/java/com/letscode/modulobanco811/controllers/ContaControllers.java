package com.letscode.modulobanco811.controllers;

import com.letscode.modulobanco811.dtos.ContaRequest;
import com.letscode.modulobanco811.dtos.UsuarioRequest;
import com.letscode.modulobanco811.model.Conta;
import com.letscode.modulobanco811.model.Usuario;
import com.letscode.modulobanco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaControllers {

    @Autowired
    ContaService contaService;

    @GetMapping
    public ResponseEntity getAllContas(){
        return contaService.getAllContas();
    }
    @PostMapping("/{id}")
    public ResponseEntity create(@PathVariable Integer id, @RequestBody ContaRequest contaRequest) {
        return contaService.create(id, contaRequest);
    }

}
