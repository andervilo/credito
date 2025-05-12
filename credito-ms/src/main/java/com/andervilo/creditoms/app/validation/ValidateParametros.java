package com.andervilo.creditoms.app.validation;

import com.andervilo.creditoms.domain.enums.TipoQuery;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ValidateParametros {

    public void validateNumeroCredito(String termoBusca) {
        if (StringUtils.isAllEmpty(termoBusca)) {
            throw new IllegalArgumentException("Número do crédito não pode ser nulo ou vazio");
        }
    }
    public void validateNumeroNfse(String termoBusca) {
        if (StringUtils.isAllEmpty(termoBusca)) {
            throw new IllegalArgumentException("Número da NFSe não pode ser nulo ou vazio");
        }
    }

    public void validateTipoQuery(TipoQuery tipo) {
        if (Objects.isNull(tipo) || !EnumUtils.isValidEnum(TipoQuery.class, tipo.name())) {
            throw new IllegalArgumentException("Tipo de query não pode ser nulo ou vazio");
        }
    }
}
