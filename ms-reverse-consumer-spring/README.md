# Reverse Microservice Consumer basado en Spring Template

Microservicio que consume el microservicio ms-reverse.

## Balanceo de carga

Incluyendo la dependencia spring-cloud-starter-eureka, se
incluye la librería Ribbon que nos sirve para hacer balanceo de carga
sobre microservicios por software, con un algoritmo Round Robbin sobre
una lista de endpoints obtenidos del servidor Eureka.

Para llevar a cabo esto, anotamos el bean RestTemplate con la anotación
@LoadBalance.

De esta forma, el endpoint con el que se llama al RestTemplate se puede
utilizar el nombre del microservicio que se registró en Eureka.



