## Frontend

El frontend ha sido desarrollado con Angular 17.3.9. Esta aplicación proporciona una interfaz de usuario que contiene una tabla para la gestion de los indicadores. Además por cada indicador se pueden ver sus historiales de medidas desde el boton **Medidas**.

### Instalación de Dependencias

1. Requisitos previos:
- **Node.js:** Asegúrate de tener la última versión de Node.js instalada.
- **Angular CLI:** Es recomendable tener la Angular Command Line Interface instalada para facilitar el desarrollo.

2. Pasos para la instalación:

- Clona el repositorio del frontend:
    ```bash
    git clone https://github.com/Bernieta/PruebaTecnicaEquinorte

    # Acceder al directorio del proyecto 
    cd Frontend/

    # Instalar dependencias
    npm install

    # Ejecutar
    ng serve

    ```
- A continuación abra el navegador e ingresa http://localhost:4200 para interactuar con la aplicación.
- La aplicación está organizada en componentes que representan diferentes partes de la interfaz de usuario.
Utiliza servicios para manejar la comunicación con la API del backend, permitiendo la obtención y el envío de datos de manera eficiente.

