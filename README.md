# Microservice Items

## Tecnologias 

### Spring Cloud Ribbon

 Es un librería que permite la comunicación entre diferentes procesos cuya principal característica es proporcionar diferentes algoritmos para realizar balanceo de carga desde el lado del cliente (client-side load balancing). Eureka lleva integrado este modulo, por lo tanto no es necesario incluirlo si vamos a usar eureka.

### Config Service Client


```
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```

### Spring Boot Actuator

Spring Boot Actuator es un subproyecto de Spring Boot. Agrega varios servicios de grado de producción a su aplicación con poco esfuerzo de su parte. 

* Actualizar configuracion con el datasource implementado, en esta caso git y github como repositorio.
```
POST http://localhost:{port}/actuator/refresh
```

