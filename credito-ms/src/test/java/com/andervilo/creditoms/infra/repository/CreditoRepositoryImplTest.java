package com.andervilo.creditoms.infra.repository;

import com.andervilo.creditoms.domain.model.Credito;
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
import java.util.Optional;

import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCredito;
import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCreditoList;
import static org.mockito.Mockito.*;

class CreditoRepositoryImplTest {
    @Mock
    CreditoJpaRepository creditoJpaRepository;
    @InjectMocks
    CreditoRepositoryImpl creditoRepositoryImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByNumeroCredito() {
        when(creditoJpaRepository.findByNumeroCredito(anyString())).thenReturn(Optional.of(getCredito()));

        Optional<Credito> result = creditoRepositoryImpl.findByNumeroCredito("1234");
        Assertions.assertEquals(getCredito(), result.orElse(null));
    }

    @Test
    void testFindByNumeroNfse() {
        when(creditoJpaRepository.findByNumeroNfse(anyString())).thenReturn(getCreditoList());

        List<Credito> result = creditoRepositoryImpl.findByNumeroNfse("4321");
        Assertions.assertEquals(getCreditoList() , result);
    }
}