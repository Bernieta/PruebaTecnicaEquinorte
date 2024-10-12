## Backend

El backend ha sido desarrollado con Java 17 y Spring Boot. Este componente se encarga de gestionar las solicitudes y respuestas de la aplicación, así como de la interacción con la base de datos.

### Instalación de Dependencias

1. Requisitos previos

- Java Development Kit (JDK): Versión 17.
- Apache Maven: Para la gestión de dependencias y la construcción del proyecto. Tambien se puede usar los gestores de Maven que contienen cada uno de los IDE de la Java: Intellij IDEA (Usado), Netbeans, Eclipse.

2. Pasos para la instalación

- Clona el repositorio
    ```bash
    git clone https://github.com/Bernieta/PruebaTecnicaEquinorte

    # Acceder al directorio del proyecto y abrirlo en su IDE
    cd Backend/
    ```
- Luego puede abrir el proyecto en su IDE de preferencia.
- Configure la conexión a la base de datos desde el archivo *application.properties*
    ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/indicator_db
    spring.datasource.username=userExample
    spring.datasource.password=passwordExample.
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```