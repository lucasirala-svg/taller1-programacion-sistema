import { Routes } from '@angular/router';
import { VolverInicioComponent } from './volver-inicio/volver-inicio';
import { RegistroPrestamo } from './registro-prestamo/registro-prestamo';

export const routes: Routes = [
  {
    path: 'volver',
    component: VolverInicioComponent,
  },
  {
    path: 'prestamos',
    component: RegistroPrestamo,
  },
  {
    path: '',
    redirectTo: 'prestamos',
    pathMatch: 'full'
  }
];
