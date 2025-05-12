package com.andervilo.creditoms.infra.publisher;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;

import static com.andervilo.creditoms.infra.constants.KafkaConstants.TOPIC;
import static org.mockito.Mockito.*;

class QueryKafkaPublisherTest {

    @Test
    void devePublicarQueryComSucesso() {
        KafkaTemplate<String, String> kafkaTemplateMock = Mockito.mock(KafkaTemplate.class);
        QueryKafkaPublisher publisher = new QueryKafkaPublisher(kafkaTemplateMock);
        String query = "MENSAGEM DE TESTE";

        publisher.publish(query);

        verify(kafkaTemplateMock, times(1)).send(TOPIC, query);
    }
}