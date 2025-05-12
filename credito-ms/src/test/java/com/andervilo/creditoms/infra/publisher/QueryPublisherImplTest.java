package com.andervilo.creditoms.infra.publisher;

import com.andervilo.creditoms.domain.publisher.QueryPublisher;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class QueryPublisherImplTest {

    @Test
    void testPublish() {
        QueryKafkaPublisher queryKafkaPublisher = mock(QueryKafkaPublisher.class);

        QueryPublisher queryPublisher = new QueryPublisherImpl(queryKafkaPublisher);

        String testMessage = "Test message";

        queryPublisher.publish(testMessage);

        verify(queryKafkaPublisher, times(1)).publish(testMessage);
    }
}