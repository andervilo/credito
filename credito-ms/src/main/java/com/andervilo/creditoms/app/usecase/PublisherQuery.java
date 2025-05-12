package com.andervilo.creditoms.app.usecase;

import com.andervilo.creditoms.app.validation.ValidateParametros;
import com.andervilo.creditoms.domain.enums.TipoQuery;
import com.andervilo.creditoms.domain.publisher.QueryPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublisherQuery {
    private final QueryPublisher publisher;
    private final ValidateParametros validate;

    public void execute(String termoBusca, TipoQuery tipo) {
        String query = String.format("{\"termoBusca\": \"%s\", \"tipo\": \"%s\"}", termoBusca, tipo);
        validate.validateTipoQuery(tipo);
        log.info("Publicando query: {}", query);
        publisher.publish(query);
        log.info("Query publicada com sucesso:.");
    }

}
