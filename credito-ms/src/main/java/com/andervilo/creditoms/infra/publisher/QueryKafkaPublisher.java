package com.andervilo.creditoms.infra.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.andervilo.creditoms.infra.constants.KafkaConstants.TOPIC;

@Service
@RequiredArgsConstructor
@Slf4j
public class QueryKafkaPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publish(String query) {
        log.info("Publicando query: {}", query);
        kafkaTemplate.send(TOPIC, query);
        log.info("Query publicada com sucesso: {}", query);
    }
}
