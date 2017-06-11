# Reverse Microservice Consumer basado en Spring Template

Microservicio que consume el microservicio ms-reverse.

## Configuración centralizada

El microservicio recupera su configuración de un servidor de configuración
centralizada, si estuviese disponible. Para ello, la aplicación Spring
Boot debe tener un fichero de
configuración bootstrap.yml o bootstrap.propperties, donde indicaremos
el nombre de la aplicación y la URL donde se encuentra el servidor de
configuración centralizada. Si el servidor de configuración centralizada
no estuviera disponible, la configuración por defecto de la aplicación
se obtendría del fichero application.yml o application.properties.

El fichero bootstrap.yml se procesa antes de que se cargue el contexto
de Spring Boot.

La propiedad que indica el nombre de la aplicación es **spring.application.name**,
y debe coincidir con el nombre de algún fichero alojado en el servidor
de configuración centralizada. Por ejemplo, si nuestra aplicación que va
a usar el servidor de configuración centralizada la vamos a llamar ***sample***,
en el servidor de configuración centralizada deberíamos tener un
fichero llamado **sample.properties** o **sample.yml**. De esta forma
nuestra aplicación cliente tendrá cargadas en memoria las propiedades incluidas
en estos ficheros y las podremos usar en nuestra aplicación con **@Value(${property_name:default_value})**.

La propiedad que indica la URI del servidor de configuración centralizada
es **spring.cloud.config.uri**

Para usar esta característica de Spring Cloud, la aplicación debe incluir
la dependencia **spring-cloud-starter-config**.


## Descubriendo el servicio

Si queremos que el servicio sea descubierto por un servidor de descubrimiento
de servicios, como Eureka de Netflix, debemos:

1. Incluir la dependencia `<dependency>
                                       <groupId>org.springframework.cloud</groupId>
                                       <artifactId>spring-cloud-starter-eureka</artifactId>
                                   </dependency>`
1. Anotar la clase principal Spring boot con **@EnableDiscoveryClient**

1. Indicar en el fichero de configuración de la aplicación la configuración
del servidor de descubrimiento
`eureka:
   client:
     serviceUrl:
       defaultZone: http://localhost:1111/eureka/`

## Balanceo de carga

Incluyendo la dependencia spring-cloud-starter-eureka, se
incluye la librería Ribbon que nos sirve para hacer balanceo de carga
sobre microservicios por software, con un algoritmo Round Robbin sobre
una lista de endpoints obtenidos del servidor Eureka.

Esto es útil cuando nuestro microservicio es consumidor de otros microservicios,
y existen varias instancias de éstos registrados en el servidor de descubrimiento. Así,
cada vez que nuestro microservicio consume otro microservicio, Ribbon se
encarga de seleccionar una de las instancias del microservicio.

Una de las opciones para llevar a cabo el balanceo de carga sobre
un microservicio es utilizar RestTemplate, y basta con anotar el bean RestTemplate con
**@LoadBalance**.

Además, el endpoint con el que se llama al RestTemplate se puede
utilizar el nombre del microservicio que se registró en Eureka. Por ello,
es conveniente establecer en el fichero de configuración de la aplicación
el endpoint con el nombre del servicio que se usará como URI en el RestTemplate.

## Circuit Breaker

Un mecanismo de Circuit Breaker lo usamos cuando no nos interesa propagar
en cascada un problema que se produce al invocar a otro servicio, de forma
que, cuando se produce ese problema damos una solución alternativa en lugar
de proporcionar un error.

En este caso, se implementa el Circuit Breaker con la librería Hyxtrix de Netflix, y
para ello basta con

1. Añadir la dependencia

`<dependency>
    <groupId>org.springframework.cloud</groupId>
 	<artifactId>spring-cloud-starter-hystrix</artifactId>
 </dependency>`

2. Anotar la clase principal Spring Boot con **@EnableCircuitBreaker**

3. En el método donde realizamos la llamada al servicio que puede dar el problema
lo anotamos con **@HystrixCommand(fallbackMethod="retrieveService")**

4. Definimos el método **retrieveService()** para dar una respuesta adecuada.

