package com.andervilo.creditoms.app.usecase;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.app.mapper.CreditoMapper;
import com.andervilo.creditoms.app.validation.ValidateParametros;
import com.andervilo.creditoms.domain.enums.TipoQuery;
import com.andervilo.creditoms.domain.model.Credito;
import com.andervilo.creditoms.domain.repository.CreditoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCredito;
import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCreditoResponse;
import static org.mockito.Mockito.*;

class FindCreditoByNumeroCreditoTest {
    @Mock
    CreditoRepository creditoRepository;
    @Mock
    CreditoMapper creditoMapper;
    @Mock
    PublisherQuery publisherQuery;
    @Mock
    ValidateParametros validateParametros;
    @InjectMocks
    FindCreditoByNumeroCredito findCreditoByNumeroCredito;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        when(creditoRepository.findByNumeroCredito(anyString())).thenReturn(Optional.of(getCredito()));
        when(creditoMapper.toResponse(any(Credito.class))).thenReturn(getCreditoResponse());
        CreditoResponse result = findCreditoByNumeroCredito.execute("1234");
        verify(validateParametros).validateNumeroCredito(anyString());
        verify(publisherQuery).execute(anyString(), any(TipoQuery.class));
        Assertions.assertEquals(getCreditoResponse(), result);
    }


}
