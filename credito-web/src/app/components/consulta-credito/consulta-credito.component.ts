import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreditoService } from '../../services/credito.service';
import { Credito } from '../../models/credito.model';

@Component({
  selector: 'app-consulta-credito',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="container">
      <h2>Consulta de Créditos</h2>
      
      <div class="search-section">
        <div class="search-group">
          <input type="text" [(ngModel)]="numeroCredito" placeholder="Número do Crédito">
          <button (click)="buscarPorCredito()">Buscar por Crédito</button>
        </div>
        
        <div class="search-group">
          <input type="text" [(ngModel)]="numeroNfse" placeholder="Número da NFSe">
          <button (click)="buscarPorNfse()">Buscar por NFSe</button>
        </div>
      </div>

      <div *ngIf="creditos.length > 0" class="results">
        <h3>Resultados</h3>
        <div class="credito-card" *ngFor="let credito of creditos">
          <div class="credito-header">
            <strong>Crédito:</strong> {{credito.numeroCredito}}
            <strong>NFSe:</strong> {{credito.numeroNfse}}
          </div>
          <div class="credito-body">
            <div><strong>Data Constituição:</strong> {{credito.dataConstituicao | date:'dd/MM/yyyy'}}</div>
            <div><strong>Tipo Crédito:</strong> {{credito.tipoCredito}}</div>
            <div><strong>Simples Nacional:</strong> {{credito.simplesNacional ? 'Sim' : 'Não'}}</div>
            <div><strong>Valor ISSQN:</strong> {{credito.valorIssqn | number:'1.2-2'}}</div>
            <div><strong>Alíquota:</strong> {{credito.aliquota | number:'1.2-2'}}%</div>
            <div><strong>Valor Faturado:</strong> {{credito.valorFaturado | number:'1.2-2'}}</div>
            <div><strong>Valor Dedução:</strong> {{credito.valorDeducao | number:'1.2-2'}}</div>
            <div><strong>Base Cálculo:</strong> {{credito.baseCalculo | number:'1.2-2'}}</div>
          </div>
        </div>
      </div>

      <div *ngIf="erro" class="erro">
        {{erro}}
      </div>
    </div>
  `,
  styles: [`
    .container {
      padding: 20px;
      max-width: 1200px;
      margin: 0 auto;
    }

    .search-section {
      display: flex;
      gap: 20px;
      margin-bottom: 30px;
    }

    .search-group {
      display: flex;
      gap: 10px;
    }

    input {
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 16px;
    }

    button {
      padding: 8px 16px;
      background-color: #007bff;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }

    .results {
      margin-top: 20px;
    }

    .credito-card {
      border: 1px solid #ddd;
      border-radius: 8px;
      padding: 15px;
      margin-bottom: 15px;
      background-color: #f8f9fa;
    }

    .credito-header {
      display: flex;
      justify-content: space-between;
      margin-bottom: 10px;
      padding-bottom: 10px;
      border-bottom: 1px solid #eee;
    }

    .credito-body {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
      gap: 10px;
    }

    .erro {
      color: #dc3545;
      padding: 10px;
      margin-top: 10px;
      border: 1px solid #dc3545;
      border-radius: 4px;
      background-color: #f8d7da;
    }
  `]
})
export class ConsultaCreditoComponent {
  numeroCredito = '';
  numeroNfse = '';
  creditos: Credito[] = [];
  erro = '';

  constructor(private creditoService: CreditoService) {}

  buscarPorCredito() {
    if (!this.numeroCredito.trim()) {
      this.erro = 'Por favor, insira um número de crédito';
      return;
    }

    this.erro = '';
    this.creditoService.findByNumeroCredito(this.numeroCredito)
      .subscribe({
        next: (credito) => {
          this.creditos = [credito];
        },
        error: (error) => {
          this.creditos = [];
          this.erro = 'Erro ao buscar crédito: ' + (error.error?.message || 'Crédito não encontrado');
        }
      });
  }

  buscarPorNfse() {
    if (!this.numeroNfse.trim()) {
      this.erro = 'Por favor, insira um número de NFSe';
      return;
    }

    this.erro = '';
    this.creditoService.findByNumeroNfse(this.numeroNfse)
      .subscribe({
        next: (creditos) => {
          this.creditos = creditos;
          if (creditos.length === 0) {
            this.erro = 'Nenhum crédito encontrado para esta NFSe';
          }
        },
        error: (error) => {
          this.creditos = [];
          this.erro = 'Erro ao buscar créditos: ' + (error.error?.message || 'NFSe não encontrada');
        }
      });
  }
}
