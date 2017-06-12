# Hystrix Dashboard

Este microservicio nos permite tener un report de los HystrixCommand que usemos
en una aplicación cliente, es decir, aquellos métodos que estén anotados con
**@HistrixCommand** en la aplicación cliente.

## Configuración

Para habilitar el microservicio como un dashboard de Hyxtrix debemos:

1. Añadir la dependencia `<dependency>
                                      <groupId>org.springframework.cloud</groupId>
                                      <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
                                  </dependency>`

2. Anotar la clase principal Spring boot con **@EnableHystrixDashboard**

3. En el microservicio cliente que queramos seguir en el dashboard de Histryx debemos
incluir la dependencia `<dependency>
                                    <groupId>org.springframework.cloud</groupId>
                                    <artifactId>spring-cloud-starter-hystrix</artifactId>
                                </dependency>`

## Funcionamiento

Si arrancamos hsytrix-dashboad, nos sale un formulario donde debemos indicarle el
hystrix.stream del microservicio del que queremos obtener el informe.

Es decir,
si arrancamos este microservicio hystrix-dashboard, por defecto arrancará la
aplicación en el puerto 9000. En el formulario, debemos indicar el hsytrix.stream
 donde se conectará hystrix-dashboard para obtener la información de los HystrixCommand
 ejecutados en la aplicación cliente. Si, por ejemplo, tenemos desplegado el
 microservicio ms-reverse-consumer-spring en el puerto 3333, la URL del hystrix stream
 asociado al microservicio será http://localhost:3333/hystrix.stream.

Si obtenemos el hystrix stream de un ms sin haber ejecutado previamente ningún método
fallback, lo normal es que el dashboard no saque ningún tipo de información. Es
necesario ejecutar algún método anotado con @HystrixCommand para que el ms cliente
envíe información a su hystrix stream y éste pueda ser explotado por el hystrix-dashboard.

## Desventajas

Mirar instancias individuales en Hystrix no es muy eficiente cuando hay muchos
microservicios a los que comprobar su estado. Por ello, se suele utilizar un
agregador de hsytrix streams como **Turbine**.