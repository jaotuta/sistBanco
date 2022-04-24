package com.letscode.modulobanco811.service.impl;

import com.letscode.modulobanco811.dtos.ContaRequest;
import com.letscode.modulobanco811.dtos.ContaResponse;
import com.letscode.modulobanco811.dtos.UsuarioRequest;
import com.letscode.modulobanco811.dtos.VerificaSaldoRequest;
import com.letscode.modulobanco811.model.Conta;
import com.letscode.modulobanco811.model.Transacao;
import com.letscode.modulobanco811.model.VerificaSaldo;
import com.letscode.modulobanco811.repository.ContaRepository;
import com.letscode.modulobanco811.repository.UsuarioRepository;
import com.letscode.modulobanco811.service.ContaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public ResponseEntity create(@PathVariable Integer id, @RequestBody ContaRequest contaRequest) {
        if(!usuarioRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não Encontrado");
        }else {
            var conta = new Conta(contaRequest);
            conta.setUsuarioID(usuarioRepository.getById(id));
            conta.setUsuarioNome(usuarioRepository.getById(id).getNome());
            conta.setUserId(usuarioRepository.getById(id).getId());
            contaRepository.save(conta);
            ContaResponse contaResponse = new ContaResponse();
            BeanUtils.copyProperties(conta, contaResponse);
            contaResponse.setUsuario(usuarioRepository.getById(id).getNome());
            return ResponseEntity.status(HttpStatus.CREATED).body(contaResponse);
        }
    }

    @Override
    public ResponseEntity getAllContas() {
        return ResponseEntity.status(HttpStatus.FOUND).body(contaRepository.findAll());
    }

    @Override
    public ResponseEntity verificaSaldo(VerificaSaldo verificaSaldo) {


        Conta conta = contaRepository.findContaByNumero(verificaSaldo.getNumConta());
        if(verificaSaldo.getValorTranferencia() <= conta.getSaldo()){
            return ResponseEntity.status(HttpStatus.OK).body("true");
        }
        return ResponseEntity.status(HttpStatus.OK).body("false");
    }

    @Override
    public void validarTransacao(Transacao value) {

        Integer numContaMandante = value.getNumContaMandante();
        Integer numContaDestinatario = value.getNumContaDestinatario();

        Conta contaMandante = contaRepository.findContaByNumero(numContaMandante);
        Conta contaDestinatario = contaRepository.findContaByNumero(numContaDestinatario);
        Float valorTransacao = value.getValorTransacao();
        float saldoDevedor = contaMandante.getSaldo() - valorTransacao;
        contaMandante.setSaldo(saldoDevedor);
        float credito = contaDestinatario.getSaldo() + valorTransacao;
        contaDestinatario.setSaldo(credito);
        contaRepository.save(contaMandante);
        contaRepository.save(contaDestinatario);
    }


}