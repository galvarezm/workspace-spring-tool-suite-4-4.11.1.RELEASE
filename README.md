# Desarrollo de MicroServicios con Spring Boot
## Evaluación
#### Autor: `Gabriel Alvarez M.`
#### Célula: `BCH-Banconexión 2.0`
#### Fecha: `10/Sept 2021`
#### Lenguaje: `Java 11`
#### Framework: `Spring Boot`
#### Herramientas: `Spring Tools Suit 4 (for mac)`
<br />

#
### Instrucciones de instalación:
### - Clonar proyecto en espacio de trabajo deseado:
#### $ git clone https://github.com/galvarezm/workspace-spring-tool-suite-4-4.11.1.RELEASE.git
### - Abrir editor Spring Tool Suite 4
### - Compilar proyecto con modelos de entidad comunes (desde terminal):
#### - $ cd springboot-app-users-common
#### - $ ./mvnw install
<br />

#
### Este espacio de trabajo considera los siguientes proyecto del tipo Spring Boot:
#### - springboot-app-config-server
#### - springboot-app-eureka-server
#### - springboot-app-service-customers
#### - springboot-app-service-moneys
#### - springboot-app-service-oauth
#### - springboot-app-service-orders
#### - springboot-app-service-repository
#### - springboot-app-users-common
#### - springboot-app-users-server
#### - springboot-app-zuul-server
<br />

#
### Pequeño diagrama con la solución:
![Preview](/spring-boot-micro-serv-diagram.png)
<br />

#
### Orden en el levantamiento de los proyecto:
#### -> springboot-app-eureka-server
#### -> springboot-app-config-server
#### -> springboot-app-service-oauth
#### -> springboot-app-users-server
#### -> springboot-app-service-repository
#### -> springboot-app-service-customers
#### -> springboot-app-service-moneys
#### -> springboot-app-service-orders
#### -> springboot-app-zuul-server
<br />

#
### Ejemplo de llamado para obtener un JWT, con el cual poder consumir el resto de los servicios:
#### (request) `post - http://localhost:8090/api/security/oauth/token`
#### (headers) `Basic Auth [Username: frontendapp, Password: 12345]`
#### (body-x-www-form-urlencoded) `username:admin,password:123456789,grant_type:password`
<br />

#
### Definición de cada proyecto:
#### springboot-app-eureka-server: `Encargado de almacenar información acerca de cada microservicio.`
#### -> springboot-app-config-server: `Encargado de centralizar la configuración de cada microservicio.`
#### -> springboot-app-service-oauth: `Encargado de gestionar la seguridad por medio de JWT.`
#### -> springboot-app-users-server: `Encargado de gestionar los usuarios que forman parte de la seguridad.`
#### -> springboot-app-service-repository: `Encargado de almacenar los datos del core.`
#### -> springboot-app-service-customers: `Encargado de gestionar los clientes del sistema.`
#### -> springboot-app-service-moneys: `Encargado de gestionar las monedas que se transan en el sistema.`
#### -> springboot-app-service-orders: `Encargado de gestionar las ordenes de compras que se transan en el sistema.`
#### -> springboot-app-zuul-server: `Encargado de redireccionar cada una de las peticiones que llegan desde los usuario o clientes.`
<br />

### ...Fin...