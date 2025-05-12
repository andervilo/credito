package com.andervilo.creditoms.rest;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.app.usecase.FindCreditoByNumeroCredito;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCreditoResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GetFindByNumeroCreditoControllerTest {

    private final FindCreditoByNumeroCredito useCase = Mockito.mock(FindCreditoByNumeroCredito.class);
    private final GetFindByNumeroCreditoController controller = new GetFindByNumeroCreditoController(useCase);

    @Test
    void testFindByNumeroCredito() {
        String numeroCredito = "12345";
        CreditoResponse expectedResponse = getCreditoResponse();
        when(useCase.execute(numeroCredito)).thenReturn(expectedResponse);

        ResponseEntity<CreditoResponse> response = controller.findByNumeroCredito(numeroCredito);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResponse, response.getBody());
    }
}