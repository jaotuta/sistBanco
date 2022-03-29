package com.letscode.modulobanco811.service.impl;

import com.letscode.modulobanco811.dtos.ContaRequest;
import com.letscode.modulobanco811.dtos.ContaResponse;
import com.letscode.modulobanco811.dtos.UsuarioRequest;
import com.letscode.modulobanco811.model.Conta;
import com.letscode.modulobanco811.repository.ContaRepository;
import com.letscode.modulobanco811.repository.UsuarioRepository;
import com.letscode.modulobanco811.service.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public ResponseEntity create(@PathVariable Integer id, @RequestBody ContaRequest contaRequest) {
        if(!usuarioRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não Encontrado");
        }else {
            var conta = new Conta(contaRequest);
            conta.setUsuarioID(usuarioRepository.getById(id));
            contaRepository.save(conta);
            ContaResponse contaResponse = new ContaResponse();
            BeanUtils.copyProperties(conta, contaResponse);
            contaResponse.setUsuario(usuarioRepository.getById(id).getNome());
            return ResponseEntity.status(HttpStatus.CREATED).body(contaResponse);
        }
    }

    @Override
    public ResponseEntity getAllContas() {
        return ResponseEntity.status(HttpStatus.FOUND).body(contaRepository.findAll());
    }


}
