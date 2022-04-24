package com.letscode.modulobanco811.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VerificaSaldoRequest {
    private String numConta;
    private String valorTranferencia;
}
