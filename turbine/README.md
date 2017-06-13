# Turbine

Este microservicio nos permite agregar los hystrix streams de varios microservicios
en un único turbine stream.

De esta forma, podemos consultar a la vez las métricas de los Hystrix command de
los microservicios.

## Configuración

Para habilitar el microservicio como un dashboard de Hyxtrix debemos:

1. Añadir la dependencia `<dependency>
                                      <groupId>org.springframework.cloud</groupId>
                                      <artifactId>spring-cloud-starter-turbine</artifactId>
                                  </dependency>`

2. Anotar la clase principal Spring boot con **@EnableTurbine**

3. En el microservicio cliente que queramos seguir en el dashboard de Histryx debemos
incluir la dependencia `<dependency>
                                    <groupId>org.springframework.cloud</groupId>
                                    <artifactId>spring-cloud-starter-hystrix</artifactId>
                                </dependency>`

## Funcionamiento

Consultando el turbine stream se realiza a través de la URL http://turbine-host:port/turbine.stream
que consultará el cluster **default**

Si tenemos un hystrix-dashboard arrancado podemos consultar el turbine stream a través
del dashboard de forma gráfica.
