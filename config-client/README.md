# Ejemplo de Spring Cloud Config Client

## Dependencias

Para poder enganchar con un servidor de configuración centralizada
basado en Spring Cloud Config, basta con construir una aplicación
Spring Boot que contenga la dependencia **spring-cloud-config-client**,
aunque la mejor manera es añadir la dependencia **spring-cloud-starter-config**.

## Fichero de configuración bootstrap

La aplicación Spring Boot que construyamos debe tener un fichero de
configuración bootstrap.yml o bootstrapt.propperties, donde indicaremos
el nombre de la aplicación y la URL donde se encuentra el servidor de
configuración centralizada.

Este fichero de configuración se procesa antes de que se cargue el contexto
de Spring Boot.

La propiedad que indica el nombre de la aplicación es **spring.application.name**,
y debe coincidir con el nombre de algún fichero alojado en el servidor
de configuración centralizada. Por ejemplo, si nuestra aplicación que va
a usar el servidor de configuración centralizada la vamos a llamar ***sample***,
en el servidor de configuración centralizada deberíamos tener un
fichero llamado **sample.properties** o **sample.yml**; de esta forma
nuestra aplicación cliente tendrá cargadas en memoria las propiedades incluidas
en estos ficheros y las podremos usar en nuestra aplicación con **@Value(${property_name:default_value})**.

La propiedad que indica la URI del servidor de configuración centralizada
es **spring.cloud.config.uri**

## Perfiles

Para nuestra aplicación podemos tener distintos ficheros de configuración
por entorno o perfiles. Así, en nuestro servidor de configuración centralizada
podemos tener un fichero **sample-develop.properties**. Y si arrancamos
nuestra aplicación con el perfil **develop**, se cargarán en nuestra aplicación
las propiedades incluidas en ***sample-develop.properties***.

Para arrancar nuestro cliente con un perfil determinado basta con usar el comando
**mvn spring-boot:run -Dspring.profiles.active=develop**.


