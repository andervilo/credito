export interface Credito {
    numeroCredito: string;
    numeroNfse: string;
    dataConstituicao: string; // LocalDate será recebido como string
    valorIssqn: number; // BigDecimal será recebido como number
    tipoCredito: string;
    simplesNacional: boolean;
    aliquota: number; // BigDecimal será recebido como number
    valorFaturado: number; // BigDecimal será recebido como number
    valorDeducao: number; // BigDecimal será recebido como number
    baseCalculo: number; // BigDecimal será recebido como number
}
