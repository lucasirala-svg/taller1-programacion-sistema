import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PrestamoService } from '../services/prestamo.service';
import { PrestamoResponse } from '../models/prestamo.model';

@Component({
  selector: 'app-registro-prestamo',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './registro-prestamo.component.html',
  styleUrl: './registro-prestamo.component.scss'
})
export class RegistroPrestamo {
  private fb = inject(FormBuilder);
  private prestamoService = inject(PrestamoService);

  prestamoForm: FormGroup;
  prestamoExitoso: PrestamoResponse | null = null;
  errorMensaje: string | null = null;

  constructor() {
    this.prestamoForm = this.fb.group({
      nombreUsuario: ['', Validators.required],
      libros: this.fb.array([], Validators.required)
    });
    this.agregarLibro();
  }

  get libros() {
    return this.prestamoForm.get('libros') as FormArray;
  }

  nuevoLibro(): FormGroup {
    return this.fb.group({
      libroId: ['', Validators.required],
      tituloLibro: ['', Validators.required]
    });
  }

  agregarLibro(): void {
    this.libros.push(this.nuevoLibro());
  }

  removerLibro(i: number): void {
    this.libros.removeAt(i);
  }

  onSubmit(): void {
    this.prestamoExitoso = null;
    this.errorMensaje = null;

    if (this.prestamoForm.invalid) {
      return;
    }

    this.prestamoService.registrarPrestamo(this.prestamoForm.value).subscribe({
      next: (response) => {
        this.prestamoExitoso = response;
        this.prestamoForm.reset();
        this.libros.clear();
        this.agregarLibro();
      },
      error: (err) => {
        if (err.error && err.error.errors) {
          const validationErrors = err.error.errors.map((e: any) => e.defaultMessage).join(', ');
          this.errorMensaje = `Error de validación: ${validationErrors}`;
        } else {
          this.errorMensaje = 'Ocurrió un error inesperado al comunicarse con el servidor.';
        }
      }
    });
  }
}
