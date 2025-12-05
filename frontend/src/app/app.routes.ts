import { Routes } from '@angular/router';
import { VolverInicioComponent } from './volver-inicio/volver-inicio';
import { InicioComponent } from './inicio/inicio'; 

export const routes: Routes = [
  {
    path: '', 
    component: InicioComponent, 
  },
  {
    path: 'volver',
    component: VolverInicioComponent,
  }
];