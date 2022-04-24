package com.letscode.modulobanco811.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "transacao")
@Entity
@Data
@NoArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "numContaMandante")
    private Integer numContaMandante;
    @Column(name = "numContaDestinatario")
    private Integer numContaDestinatario;
    @Column(name = "valorTransacao")
    private Float valorTransacao;

}
