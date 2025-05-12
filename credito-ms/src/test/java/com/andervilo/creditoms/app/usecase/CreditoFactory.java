package com.andervilo.creditoms.app.usecase;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.domain.model.Credito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class CreditoFactory {
    public static Credito getCredito() {
        Credito credito = new Credito();
        credito.setId(1L);
        credito.setNumeroCredito("1234");
        credito.setNumeroNfse("4321");
        credito.setDataConstituicao(LocalDate.of(2025, Month.MAY, 12));
        credito.setValorIssqn(new BigDecimal(0));
        credito.setTipoCredito("tipoCredito");
        credito.setSimplesNacional(true);
        credito.setAliquota(new BigDecimal(0));
        credito.setValorFaturado(new BigDecimal(0));
        credito.setValorDeducao(new BigDecimal(0));
        credito.setBaseCalculo(new BigDecimal(0));
        return credito;
    }

    public static List<Credito> getCreditoList() {
        Credito credito = new Credito();
        credito.setId(1L);
        credito.setNumeroCredito("1234");
        credito.setNumeroNfse("4321");
        credito.setDataConstituicao(LocalDate.of(2025, Month.MAY, 12));
        credito.setValorIssqn(new BigDecimal(0));
        credito.setTipoCredito("tipoCredito");
        credito.setSimplesNacional(true);
        credito.setAliquota(new BigDecimal(0));
        credito.setValorFaturado(new BigDecimal(0));
        credito.setValorDeducao(new BigDecimal(0));
        credito.setBaseCalculo(new BigDecimal(0));

        Credito credito2 = new Credito();
        credito2.setId(2L);
        credito2.setNumeroCredito("1235");
        credito2.setNumeroNfse("4321");
        credito2.setDataConstituicao(LocalDate.of(2025, Month.MAY, 12));
        credito2.setValorIssqn(new BigDecimal(0));
        credito2.setTipoCredito("tipoCredito");
        credito2.setSimplesNacional(true);
        credito2.setAliquota(new BigDecimal(0));
        credito2.setValorFaturado(new BigDecimal(0));
        credito2.setValorDeducao(new BigDecimal(0));
        credito2.setBaseCalculo(new BigDecimal(0));

        return List.of(credito, credito2);
    }

    public static CreditoResponse getCreditoResponse() {
        CreditoResponse creditoResponse = new CreditoResponse(
            "1234",
            "4321",
            LocalDate.of(2025, Month.MAY, 12),
            new BigDecimal(0),
            "tipoCredito",
            true,
            new BigDecimal(0),
            new BigDecimal(0),
            new BigDecimal(0),
            new BigDecimal(0)
        );
        return creditoResponse;
    }

    public static List<CreditoResponse> getCreditoResponseList() {
        CreditoResponse creditoResponse = new CreditoResponse(
                "1234",
                "4321",
                LocalDate.of(2025, Month.MAY, 12),
                new BigDecimal(0),
                "tipoCredito",
                true,
                new BigDecimal(0),
                new BigDecimal(0),
                new BigDecimal(0),
                new BigDecimal(0)
        );

        CreditoResponse creditoResponse2 = new CreditoResponse(
                "1235",
                "4321",
                LocalDate.of(2025, Month.MAY, 12),
                new BigDecimal(0),
                "tipoCredito",
                true,
                new BigDecimal(0),
                new BigDecimal(0),
                new BigDecimal(0),
                new BigDecimal(0)
        );

        return List.of(creditoResponse, creditoResponse2);
    }
}
