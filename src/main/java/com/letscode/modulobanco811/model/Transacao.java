package com.letscode.modulobanco811.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "usuario")
@Entity
@Data
@NoArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta contaID;

    @Column(name = "cpfDestinatario")
    private Integer cpfDestinatario;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id_destinatario", referencedColumnName = "id")
    private Conta contaIdDestinatario;

    @Column(name = "senha")
    private String senha;


    @Column(name = "valor")
    private BigDecimal valor;

}
