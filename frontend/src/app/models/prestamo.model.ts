export interface PrestamoDetalle {
  libroId: number;
  tituloLibro: string;
}

export interface PrestamoRequest {
  nombreUsuario: string;
  libros: PrestamoDetalle[];
}

export interface PrestamoResponse {
  id: number;
  nombreUsuario: string;
  fechaPrestamo: string;
  totalLibros: number;
  libros: PrestamoDetalle[];
}
