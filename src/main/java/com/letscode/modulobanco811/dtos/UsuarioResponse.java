package com.letscode.modulobanco811.dtos;

import com.letscode.modulobanco811.model.Conta;
import com.letscode.modulobanco811.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UsuarioResponse {

    private Integer id;
    private String nome;
    private String cpf;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public UsuarioResponse(Usuario usuario) {
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.senha = usuario.getSenha();
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.dataAtualizacao = usuario.getDataAtualizacao();
    }

    public static List<UsuarioResponse> toResponse(List<Usuario> usuarios){
        return  usuarios.stream().map(UsuarioResponse::new).collect(Collectors.toList());
    }
}
