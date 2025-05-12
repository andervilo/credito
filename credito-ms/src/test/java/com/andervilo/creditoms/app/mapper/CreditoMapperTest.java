package com.andervilo.creditoms.app.mapper;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.domain.model.Credito;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCredito;
import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCreditoList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditoMapperTest {

    private final CreditoMapper mapper = new CreditoMapper();

    @Test
    void testToResponse() {
        Credito credito = getCredito();

        CreditoResponse response = mapper.toResponse(credito);

        assertEquals(credito.getNumeroCredito(), response.numeroCredito());
        assertEquals(credito.getNumeroNfse(), response.numeroNfse());
        assertEquals(credito.getDataConstituicao(), response.dataConstituicao());
        assertEquals(credito.getValorIssqn(), response.valorIssqn());
        assertEquals(credito.getTipoCredito(), response.tipoCredito());
        assertEquals(credito.isSimplesNacional(), response.simplesNacional());
        assertEquals(credito.getAliquota(), response.aliquota());
        assertEquals(credito.getValorFaturado(), response.valorFaturado());
        assertEquals(credito.getValorDeducao(), response.valorDeducao());
        assertEquals(credito.getBaseCalculo(), response.baseCalculo());
    }

    @Test
    void testToResponseList() {

        List<Credito> creditos = getCreditoList();

        List<CreditoResponse> responses = mapper.toResponseList(creditos);

        assertEquals(2, responses.size());
        assertEquals(creditos.get(0).getNumeroCredito(), responses.get(0).numeroCredito());
        assertEquals(creditos.get(1).getNumeroCredito(), responses.get(1).numeroCredito());
    }
}