package com.andervilo.creditoms.app.usecase;

import com.andervilo.creditoms.app.validation.ValidateParametros;
import com.andervilo.creditoms.domain.enums.TipoQuery;
import com.andervilo.creditoms.domain.publisher.QueryPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class PublisherQueryTest {

    private final QueryPublisher publisher = Mockito.mock(QueryPublisher.class);

    private final ValidateParametros validate = new ValidateParametros();

    private PublisherQuery publisherQuery;

    @BeforeEach
    void setUp() {
        publisherQuery = new PublisherQuery(publisher, validate);
    }


    @Test
    void executePublishesQuerySuccessfully() {
        String termoBusca = "12345";
        TipoQuery tipo = TipoQuery.CREDITO;

        publisherQuery.execute(termoBusca, tipo);

        String expectedQuery = "{\"termoBusca\": \"12345\", \"tipo\": \"CREDITO\"}";
        verify(publisher).publish(expectedQuery);
    }

    @Test
    void executeHandlesEmptySearchTerm() {
        String termoBusca = "";
        TipoQuery tipo = TipoQuery.NFSE;

        publisherQuery.execute(termoBusca, tipo);

        String expectedQuery = "{\"termoBusca\": \"\", \"tipo\": \"NFSE\"}";
        verify(publisher).publish(expectedQuery);
    }

    @Test
    void executeHandlesNullSearchTerm() {
        String termoBusca = null;
        TipoQuery tipo = TipoQuery.CREDITO;

        publisherQuery.execute(termoBusca, tipo);

        String expectedQuery = "{\"termoBusca\": \"null\", \"tipo\": \"CREDITO\"}";
        verify(publisher).publish(expectedQuery);
    }

    @Test
    void executeHandlesNullTipoQuery() {
        String termoBusca = "example";
        TipoQuery tipo = null;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            publisherQuery.execute(termoBusca, tipo);
        });

        assertEquals("Tipo de query não pode ser nulo ou vazio", exception.getMessage());
    }
}