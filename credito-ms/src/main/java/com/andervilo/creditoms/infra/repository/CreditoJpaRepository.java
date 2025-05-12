package com.andervilo.creditoms.infra.repository;

import com.andervilo.creditoms.domain.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CreditoJpaRepository extends JpaRepository<Credito, Long> {
    Optional<Credito> findByNumeroCredito(String numeroCredito);

    List<Credito> findByNumeroNfse(String numeroNfse);
}
