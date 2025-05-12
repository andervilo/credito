package com.andervilo.creditoms.app.usecase;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.app.mapper.CreditoMapper;
import com.andervilo.creditoms.app.validation.ValidateParametros;
import com.andervilo.creditoms.domain.enums.TipoQuery;
import com.andervilo.creditoms.domain.model.Credito;
import com.andervilo.creditoms.domain.repository.CreditoRepository;
import com.andervilo.creditoms.infra.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindCreditoByNumeroCredito {

    private final CreditoRepository creditoRepository;
    private final CreditoMapper creditoMapper;
    private final PublisherQuery publisherQuery;
    private final ValidateParametros validate;

    public CreditoResponse execute(String numeroCredito) {
        log.info("Buscando crédito pelo número do crédito: {}", numeroCredito);
        validate.validateNumeroCredito(numeroCredito);
        Credito credito = creditoRepository.findByNumeroCredito(numeroCredito)
            .orElseThrow(() -> new ResourceNotFoundException("Crédito não encontrado com o número: " + numeroCredito, new Throwable("message")));
        publisherQuery.execute(numeroCredito, TipoQuery.CREDITO);
        return creditoMapper.toResponse(credito);
    }
}
