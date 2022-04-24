package com.letscode.modulobanco811.repository;

import com.letscode.modulobanco811.model.Conta;
import com.letscode.modulobanco811.model.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {


    List<Conta> findBySaldoLessThanEqual(BigDecimal valor);
    List<Conta> findBySaldoLessThan(BigDecimal valor);
    List<Conta> findBySaldoGreaterThan(BigDecimal valor);
    List<Conta> findBySaldoBetween(BigDecimal valorInicial, BigDecimal valorFinal);
    List<Conta> findBySaldoIn(List<BigDecimal> valores);

    @Query("Select c from Conta c where (c.tipoConta = :tipoConta and c.agencia = :agencia) or (c.tipoConta = :tipoConta or c.saldo = :saldo) ")
   List<Conta> findByTipoContaAndAgenciaOrTipoContaAndSaldo(
           @Param("tipoConta")TipoConta tipoConta,
           @Param("agencia") String agencia,
           @Param("saldo") BigDecimal saldo
           );

    @Query(value = "select * from conta c (where c.tipo_conta = :tipoConta AND data_criacao >= :dataCriacao) OR c.saldo = :saldo", nativeQuery = true)
    List<Conta> findByDataCriacaoAndTipoContaOrSaldo(
            @Param("dataCriacao")LocalDateTime dataCriacao,
            @Param("tipoConta")TipoConta tipoConta,
            @Param("saldo") BigDecimal saldo
            );

    Conta findByNumero(Integer numero);
    Conta findContaByNumero(Integer numero);
}
