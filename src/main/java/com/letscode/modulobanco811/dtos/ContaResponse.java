package com.letscode.modulobanco811.dtos;

import com.letscode.modulobanco811.model.TipoConta;
import com.letscode.modulobanco811.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class ContaResponse {

    private Integer numero;
    private Integer agencia;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    private BigDecimal saldo;
    private String usuario;


}
