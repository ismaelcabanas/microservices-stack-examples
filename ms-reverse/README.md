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

## Descubriendo el servicio

Si queremos que el servicio sea descubierto por un servidor de descubrimiento
de servicios, como Eureka de Netflix, debemos:

1. Incluir la dependencia `<dependency>
                                       <groupId>org.springframework.cloud</groupId>
                                       <artifactId>spring-cloud-starter-eureka</artifactId>
                                   </dependency>`
1. Anotar la clase principal con **@EnableDiscoveryClient**

1. Indicar en el fichero de configuración de la aplicación la configuración
del servidor de descubrimiento
`eureka:
   client:
     serviceUrl:
       defaultZone: http://localhost:1111/eureka/`

