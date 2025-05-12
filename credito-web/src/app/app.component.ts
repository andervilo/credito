import { Component } from '@angular/core';
import { ConsultaCreditoComponent } from './components/consulta-credito/consulta-credito.component';

@Component({
  selector: 'app-root',
  template: '<app-consulta-credito></app-consulta-credito>',
  standalone: true,
  imports: [ConsultaCreditoComponent]
})
export class AppComponent {
  title = 'credito-web';
}
