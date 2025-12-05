import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-volver-inicio',
  standalone: true,
  imports: [],
  templateUrl: './volver-inicio.html',
  styleUrl: './volver-inicio.css'
})
export class VolverInicioComponent {
  constructor(private router: Router) {}

  volverAlInicio(): void {
    this.router.navigate(['/']);
  }
}
