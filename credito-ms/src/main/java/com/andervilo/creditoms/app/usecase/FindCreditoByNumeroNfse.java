package com.andervilo.creditoms.app.usecase;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.app.mapper.CreditoMapper;
import com.andervilo.creditoms.app.validation.ValidateParametros;
import com.andervilo.creditoms.domain.enums.TipoQuery;
import com.andervilo.creditoms.domain.repository.CreditoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindCreditoByNumeroNfse {

    private final CreditoRepository creditoRepository;
    private final CreditoMapper creditoMapper;
    private final PublisherQuery publisherQuery;
    private final ValidateParametros validate;

     public List<CreditoResponse> execute(String numeroNfse) {
         log.info("Buscando crédito pelo número da NFSe: {}", numeroNfse);
         validate.validateNumeroNfse(numeroNfse);
            publisherQuery.execute(numeroNfse, TipoQuery.NFSE);
         return creditoMapper.toResponseList(creditoRepository.findByNumeroNfse(numeroNfse));
     }
}
