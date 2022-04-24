package com.letscode.modulobanco811.dtos;

import com.letscode.modulobanco811.model.TipoConta;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class ContaRequest {

    private Integer numero;
    private Integer agencia;
    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;
    private Float saldo;
}
