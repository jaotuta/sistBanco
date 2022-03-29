package com.letscode.modulobanco811.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.letscode.modulobanco811.dtos.UsuarioRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "usuario")
@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @Column(name = "data_cricao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "usuarioID", cascade = CascadeType.ALL)
    private List<Conta> contas;

    public Usuario(UsuarioRequest usuarioRequest) {

        this.cpf = usuarioRequest.getCpf();
        this.nome = usuarioRequest.getNome();
        this.senha = usuarioRequest.getSenha();
    }
}
