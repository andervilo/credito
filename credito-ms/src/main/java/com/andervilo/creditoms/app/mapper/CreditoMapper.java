package com.andervilo.creditoms.app.mapper;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.domain.model.Credito;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreditoMapper {

    public CreditoResponse toResponse(Credito credito) {
        return new CreditoResponse(
            credito.getNumeroCredito(),
            credito.getNumeroNfse(),
            credito.getDataConstituicao(),
            credito.getValorIssqn(),
            credito.getTipoCredito(),
            credito.isSimplesNacional(),
            credito.getAliquota(),
            credito.getValorFaturado(),
            credito.getValorDeducao(),
            credito.getBaseCalculo()
        );
    }

    public List<CreditoResponse> toResponseList(List<Credito> creditos) {
        return creditos.stream()
            .map(this::toResponse)
            .toList();
    }
}
