package com.andervilo.creditoms.rest;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.app.usecase.FindCreditoByNumeroCredito;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/creditos")
@RequiredArgsConstructor
@Tag(name = "Créditos", description = "Operações de Créditos")
public class GetFindByNumeroCreditoController {
     private final FindCreditoByNumeroCredito useCase;

     @GetMapping("/credito/{numeroCredito}")
     @Operation(summary = "Busca um crédito pelo número do crédito", description = "Retorna um crédito dado o número do crédito.")
     public ResponseEntity<CreditoResponse> findByNumeroCredito(@PathVariable String numeroCredito) {
         return ResponseEntity.ok(useCase.execute(numeroCredito));
     }
}
