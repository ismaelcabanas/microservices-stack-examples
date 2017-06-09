# Eureka Server

Pieza fundamental en la arquitectura de microservicios. Este servidor
se encargará de llevar un registro de microservicios registrados para
que se puedan conocer y consumir entre ellos.

La implementación estará basada en Eureka Server de Netflix. Para ello,
basta con crear una aplicación Spring Boot y anotar la clase principal con
**@EnableEurekaServer**.

## Servidor de configuración

El servidor de Eureka se configura para que obtenga su configuración de
un servidor de configuración centralizada, y para ello, debe haber un fichero
eureka-server.yml en el repositorio de configuración

## Aplicaciones cliente

Los microservicios que deseen registrarse en el servidor de Eureka


