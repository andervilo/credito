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
import java.util.List;

import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCreditoList;
import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCreditoResponseList;
import static org.mockito.Mockito.*;

class FindCreditoByNumeroNfseTest {
    @Mock
    CreditoRepository creditoRepository;
    @Mock
    CreditoMapper creditoMapper;
    @Mock
    PublisherQuery publisherQuery;
    @Mock
    ValidateParametros validateParametros;
    @InjectMocks
    FindCreditoByNumeroNfse findCreditoByNumeroNfse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecute() {
        when(creditoRepository.findByNumeroNfse(anyString())).thenReturn(getCreditoList());
        when(creditoMapper.toResponseList(any(List.class))).thenReturn(getCreditoResponseList());
        List<CreditoResponse> result = findCreditoByNumeroNfse.execute("4321");
        verify(validateParametros).validateNumeroNfse(anyString());
        verify(publisherQuery).execute(anyString(), any(TipoQuery.class));
        Assertions.assertEquals(getCreditoResponseList(), result);
    }
}
