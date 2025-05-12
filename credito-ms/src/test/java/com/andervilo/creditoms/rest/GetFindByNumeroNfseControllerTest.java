package com.andervilo.creditoms.rest;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.app.usecase.FindCreditoByNumeroNfse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.andervilo.creditoms.app.usecase.CreditoFactory.getCreditoResponseList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GetFindByNumeroNfseControllerTest {

    private final FindCreditoByNumeroNfse useCase = Mockito.mock(FindCreditoByNumeroNfse.class);
    private final GetFindByNumeroNfseController controller = new GetFindByNumeroNfseController(useCase);

    @Test
    void testFindByNumeroNfse() {
        String numeroNfse = "12345";
        List<CreditoResponse> mockResponse = getCreditoResponseList();
        when(useCase.execute(numeroNfse)).thenReturn(mockResponse);

        ResponseEntity<List<CreditoResponse>> response = controller.findByNumeroNfse(numeroNfse);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockResponse, response.getBody());
    }
}