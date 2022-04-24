package com.letscode.modulobanco811.jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.letscode.modulobanco811.model.Transacao;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class TransferenciaMsgDeserializer implements Deserializer<Transacao> {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public Transacao deserialize(String s, byte[] bytes) {
        try {
        if(Objects.nonNull(bytes)){

                return mapper.readValue(new String(bytes, StandardCharsets.UTF_8), Transacao.class);
            }
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
