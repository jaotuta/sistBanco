package com.letscode.modulobanco811.model;

import com.letscode.modulobanco811.dtos.ContaRequest;
import com.letscode.modulobanco811.dtos.UsuarioRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "conta")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "agencia")
    private Integer agencia;

    @Column(name = "tipo_conta")
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "data_cricao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuarioID;

    public Conta(ContaRequest contaRequest) {

        this.numero = contaRequest.getNumero();
        this.agencia = contaRequest.getAgencia();
        this.tipoConta = contaRequest.getTipoConta();
        this.saldo = contaRequest.getSaldo();
    }

}
