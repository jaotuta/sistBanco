package com.letscode.modulobanco811.service;

import com.letscode.modulobanco811.dtos.ContaRequest;
import com.letscode.modulobanco811.dtos.UsuarioRequest;
import com.letscode.modulobanco811.model.Conta;
import com.letscode.modulobanco811.model.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ContaService {
    ResponseEntity create(Integer id , ContaRequest contaRequest);
    ResponseEntity getAllContas();
}
