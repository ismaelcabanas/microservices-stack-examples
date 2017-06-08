# Reverse Microservice

Microservicio que invierte los caracteres de una cadena dada.

## Construcción y despliegue

`$ mvn clean spring-boot:run`

Con esta sentencia arranca un contenedor de servlet embebido y
despliega la aplicación Spring Boot.

Cuando se arranca la aplicación intenta conectarse al servidor de
configuración centralizada indicado en el fichero **bootstrap.yml**.

Si el servicdor de configuración centralizada está disponible, intentará cargar
las propiedades de la aplicación de un fichero {applicacion-name}-{profile}.[yml|properties]

