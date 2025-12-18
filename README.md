# Sistema de Gestión de Biblioteca - Taller 1 Programacion

## 1. Preparación del Entorno (Ubuntu/WSL)

### Ventajas de las Herramientas Utilizadas

*   **SDKMAN!:** Permite gestionar múltiples versiones de Java y otras herramientas de la JVM de manera sencilla, evitando conflictos y facilitando el cambio de contexto entre proyectos.
*   **NVM (Node Version Manager):** Similar a SDKMAN!, gestiona las versiones de Node.js. Es esencial para garantizar la compatibilidad del frontend, ya que diferentes proyectos de Angular pueden requerir distintas versiones de Node.
*   **Docker:** Encapsula la aplicación en contenedores, garantizando que el entorno sea idéntico en desarrollo, pruebas y producción. Esto elimina el clásico problema de "en mi máquina sí funciona".
	
## Backend (Java):

### Instalar SDKMAN!
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"

### Instalar Java 17
sdk install java 17.0.11-tem

### Instalar Maven
sdk install maven

## Frontend (Java):

### Instalar NVM
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.7/install.sh | bash

### Instalar Node.js LTS
nvm install --lts
nvm use --lts

### Instalar Angular CLI
npm install -g @angular/cli

## Docker:

### Probar instalación de Docker
docker run hello-world

### Pasos para Reproducir el Entorno

1. Clonar el repositorio: git clone https://github.com/lucasirala-svg/taller1-programacion-sistema.git
2. Instalar y configurar las herramientas del backend siguiendo los comandos anteriores.
3. Instalar y configurar las herramientas del frontend siguiendo los comandos anteriores.
4. Instalar Docker Desktop y habilitar la integración con WSL.

## Integración Frontend + Backend

Esta sección describe la integración entre la pantalla de "Registro de Préstamo" en Angular y la API REST del backend.

### Flujo de Integración

1.  El usuario completa el formulario en la pantalla de Angular con su nombre y los libros que desea prestar.
2.  Al hacer clic en "Registrar Préstamo", Angular crea un objeto JSON (`PrestamoRequestDTO`).
3.  El `PrestamoService` de Angular envía este objeto mediante una petición `POST` al endpoint del backend.
4.  El backend valida los datos. Si son inválidos, retorna un error 400 con los mensajes de validación.
5.  Si los datos son válidos, el `PrestamoService` de Java registra el préstamo y retorna un `PrestamoResponseDTO` con el estado 201.
6.  Angular recibe la respuesta. Si es exitosa, muestra un mensaje de confirmación con los datos del préstamo. Si es un error, muestra los mensajes de validación al usuario.

### Endpoint Utilizado

*   **URL:** `POST /api/prestamos`
*   **Request Body (Ejemplo):**
    ```json
    {
      "nombreUsuario": "Isabel Allende",
      "libros": [
        {
          "libroId": 789,
          "tituloLibro": "La Casa de los Espíritus"
        }
      ]
    }
    ```
*   **Response Body (Ejemplo Exitoso):**
    ```json
    {
      "id": 2,
      "nombreUsuario": "Isabel Allende",
      "fechaPrestamo": "2025-12-18T22:15:30.123456",
      "totalLibros": 1,
      "libros": [
        {
          "libroId": 789,
          "tituloLibro": "La Casa de los Espíritus"
        }
      ]
    }
    ```
