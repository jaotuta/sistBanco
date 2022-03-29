package com.letscode.modulobanco811.dtos;

import com.letscode.modulobanco811.model.Conta;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UsuarioRequest {

    private String nome;
    private String cpf;
    private String senha;

}
