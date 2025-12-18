import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PrestamoRequest, PrestamoResponse } from '../models/prestamo.model';

@Injectable({
  providedIn: 'root'
})
export class PrestamoService {

  private apiUrl = '/api/prestamos';

  constructor(private http: HttpClient) { }

  registrarPrestamo(prestamo: PrestamoRequest): Observable<PrestamoResponse> {
    return this.http.post<PrestamoResponse>(this.apiUrl, prestamo);
  }
}
