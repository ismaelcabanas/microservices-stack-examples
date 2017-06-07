# Ejemplo de Spring Cloud Config Server

Con el servidor de configuración se tiene un lugar centralizado para
gestionar las propiedades de aplicaciones a través de cualquier entorno.

La implementación por defecto del almacenamiento en el lado
 del servidor utiliza Git, ya que soporta de manera muy sencilla
  versiones de configuraciones entre distitntos entornos.

Se pueden añadir distintas implementaciones de forma sencilla.

## Cambios de la configuración en caliente

En alguna ocasión, puede ser interesante poder cambiar la configuración
de una aplicación en caliente, es decir, si por ejemplo estamos utilizando
Git como backend de los ficheros de configuración, y hacemos una modificación
de una fichero de configuración de una de nuestras aplicaciones y hacemos push
de esa modificación al repositorio, sería interesante que esa modificación se viera
reflejada en nuestra aplicación, sin tener que pararla y volverla a levantar.

Para esta funcionalidad tenemos Spring Cloud Bus y hay que activarla en el servidor de
configuración añadiendo las dependencias **spring-cloud-starter-bus-amqp** y
**spring-cloud-config-monitor**.

La primera de ellas es para que Spring configure un broker ligero de mensajes y la segunda
es para hacer disponible en el servidor de configuración un endpoint (/monitor) al que se
le llame cuando hay un cambio en alguno de los ficheros de configuración, en Github por ejemplo, se
haría a través de un WebHook, de forma que el endpoint crearía una notificación en el servidor de
configuración centralizada que enviaría a la aplicación cliente, y cuando ésta la tratara pediría al
servidor de configuración centralizada actualizar las propiedades para tenerlas refrescadas.

Resumiendo, debemos realizar los siguientes pasos para activar la funcionalidad de cambios de la configuración
en caliente:

1. Incluir las dependencias spring-cloud-starter-bus-amqp y spring-cloud-config-monitor
1. Tener arrancado un message broker AMQP como sistema broadcast entre nodos de un sistema distribuido. Como por ejemplo,
RabbitMQ, que se puede desplegar con Docker `docker run -d --hostname rabbitmq -p 5672:5672 --name my-rabbit rabbitmq:3.6.10`. Cuando
 el servidor RabbitMQ se arranca, se crea el usuario guest con contraseña guest.
1. Incluir en el application.yml del servidor de configuración centralizada la configuración del
servidor RabbitMQ
1. En la aplicación cliente en la que se quiere usar la funcionalidad de refrescar
las propiedades de la aplicación en caliente hay que:
    1. incluir la siguiente dependencia
`<dependency>
     <groupId>org.springframework.cloud</groupId>
     <artifactId>spring-cloud-starter-bus-amqp</artifactId>
 </dependency>`

    1. Anotar con @RefreshScope el bean que contenga la propiedades de configuración que
    deseemos refrescar (no tienen por qué ser todas la propiedades)

 1. Si nuestro repositorio backend es Github, Gitlab o BitBucket, debemos configurar un Webhook como se
 explica en el siguiente [enlace](http://zoltanaltfatter.com/2016/06/30/centralized-configuration-with-spring-cloud-config/).


