package com.andervilo.creditoms.rest;

import com.andervilo.creditoms.app.dto.CreditoResponse;
import com.andervilo.creditoms.app.usecase.FindCreditoByNumeroNfse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/creditos")
@RequiredArgsConstructor
@Tag(name = "Créditos", description = "Operações de Créditos")
public class GetFindByNumeroNfseController {
     private final FindCreditoByNumeroNfse useCase;

     @GetMapping("/{numeroNfse}")
     @Operation(summary = "Busca um crédito pelo número da NFSe", description = "Retorna uma lista de créditos dado o número da NFSe.")
     public ResponseEntity<List<CreditoResponse>> findByNumeroNfse(@PathVariable String numeroNfse) {
         return ResponseEntity.ok(useCase.execute(numeroNfse));
     }
}
