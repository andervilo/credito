package com.andervilo.creditoms.app.validation;

import com.andervilo.creditoms.domain.enums.TipoQuery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidateParametrosTest {
    ValidateParametros validateParametros = new ValidateParametros();

    @Test
    void testValidateNumeroCreditoComValorValido() {
        validateParametros.validateNumeroCredito("12345");
    }

    @Test
    void testValidateNumeroCreditoComValorNulo() {
        assertThrows(IllegalArgumentException.class, () -> validateParametros.validateNumeroCredito(null));
    }

    @Test
    void testValidateNumeroCreditoComValorVazio() {
        assertThrows(IllegalArgumentException.class, () -> validateParametros.validateNumeroCredito(""));
    }

    @Test
    void testValidateNumeroNfseComValorValido() {
        validateParametros.validateNumeroNfse("67890");
    }

    @Test
    void testValidateNumeroNfseComValorNulo() {
        assertThrows(IllegalArgumentException.class, () -> validateParametros.validateNumeroNfse(null));
    }

    @Test
    void testValidateNumeroNfseComValorVazio() {
        assertThrows(IllegalArgumentException.class, () -> validateParametros.validateNumeroNfse(""));
    }

    @Test
    void testValidateTipoQueryComValorValido() {
        validateParametros.validateTipoQuery(TipoQuery.NFSE);
    }

    @Test
    void testValidateTipoQueryComValorNulo() {
        assertThrows(IllegalArgumentException.class, () -> validateParametros.validateTipoQuery(null));
    }

    @Test
    void testValidateTipoQueryComValorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> validateParametros.validateTipoQuery(TipoQuery.valueOf("INVALIDO")));
    }
}