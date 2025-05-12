package com.andervilo.creditoms.infra.repository;

import com.andervilo.creditoms.domain.model.Credito;
import com.andervilo.creditoms.domain.repository.CreditoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CreditoRepositoryImpl implements CreditoRepository {

    private final CreditoJpaRepository creditoJpaRepository;

    @Override
    public Optional<Credito> findByNumeroCredito(String numeroCredito) {
        return creditoJpaRepository.findByNumeroCredito(numeroCredito);
    }

    @Override
    public List<Credito> findByNumeroNfse(String numeroNfse) {
        return creditoJpaRepository.findByNumeroNfse(numeroNfse);
    }
}
