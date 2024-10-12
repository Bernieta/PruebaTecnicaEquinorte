import { Routes } from '@angular/router';
import { IndicatorComponent } from './indicator/indicator.component';
import { FormIndicatorComponent } from './form-indicator/form-indicator.component';
import { MeasurementComponent } from './measurement/measurement.component';

export const routes: Routes = [
  {
    path: '',
    component: IndicatorComponent,
    title: 'Inicio'
  },
  {
    path: 'form-indicator/:id',
    component: FormIndicatorComponent,
    title: 'Formulario - Indicador'
  },
  {
    path: 'measurement/:indicatorId',
    component: MeasurementComponent,
    title: 'Medidas'
  },
  {
    path: '**',
    redirectTo: '',
    pathMatch: 'full',
  },
];
