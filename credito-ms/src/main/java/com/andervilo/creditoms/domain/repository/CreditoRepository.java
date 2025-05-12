package com.andervilo.creditoms.domain.repository;

import com.andervilo.creditoms.domain.model.Credito;

import java.util.List;
import java.util.Optional;

public interface CreditoRepository {
    Optional<Credito> findByNumeroCredito(String numeroCredito);

    List<Credito> findByNumeroNfse(String numeroNfse);
}
