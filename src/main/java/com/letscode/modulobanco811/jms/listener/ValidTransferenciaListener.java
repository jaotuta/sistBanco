package com.letscode.modulobanco811.jms.listener;

import com.letscode.modulobanco811.model.Transacao;
import com.letscode.modulobanco811.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidTransferenciaListener {

    private final ContaService contaService;
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Transacao> payload) {
        contaService.validarTransacao(payload.value());
    }
}
