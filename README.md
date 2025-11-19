# Proyecto de Sistema con Java y Angular - Taller 1 Programacion

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
