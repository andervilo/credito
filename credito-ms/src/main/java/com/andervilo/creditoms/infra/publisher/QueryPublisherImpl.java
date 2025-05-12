package com.andervilo.creditoms.infra.publisher;

import com.andervilo.creditoms.domain.publisher.QueryPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryPublisherImpl implements QueryPublisher {

    private final QueryKafkaPublisher queryKafkaPublisher;
    @Override
    public void publish(String Message) {
        queryKafkaPublisher.publish(Message);
    }
}
