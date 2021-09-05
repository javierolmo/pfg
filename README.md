# Melodía

Es un software de composición musical desarrollado como proyecto de fin de grado en el Grado de Ingeniería informática 
de la UNED.

Consiste en un servicio web capaz de realizar composiciones musicales utilizando diversos algoritmos (actualmente sólo 
implementado el algoritmo genético). 

---

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._



### Pre-requisitos 📋

* Java 1.8 (o superior)
* Maven
* Docker
* NodeJS

### Ejecutar en local

1. Construir imágenes a partir de cada módulo  
``docker-compose build``

2. Crear los contenedores a partir de las imágenes  
``docker-compose up``

### Desarrollar

Una manera cómoda de trabajar con este proyecto sería primero levantar en local todos los módulos del proyecto 
siguiendo los pasos anteriores y según en qué módulo se quiera trabajar, detener dicho contenedor y ejecutar este fuera 
de docker para mayor agilidad. 

Por ejemplo, para trabajar con el frontend, primero se detendría dicho contenedor:  
``docker-compose stop frontend``  
Y a continuación se levantaría el servidor local de desarrollo:  
``cd pfg-frontend``  
``ng serve``

---

## Módulos 💊

|       	                |Finalidad 	|Lenguaje       |Framework      |
|---------------------------|:---------:|:-------------:|:-------------:|
|pfg-backend	            |Servicio   |Java           |Spring         |
|pfg-frontend               |Servicio   |HTML, TS, CSS  |Angular        |
|pfg-commons                |Librería   |Java           |-              |
|pfg-composer-genetic       |Servicio   |Java           |-              |
|pfg-composer-neural-network|Servicio   |Python         |-              |

### pfg-backend

### pfg-frontend

### pfg-commons

### pfg-composer-genetic

### pfg-composer-neural-network

---

## Autores ✒️

* **Javier Olmo Injerto** - *Desarrollador* - [jolmo60](mailto:jolmo60@alumno.uned.es)
* **Jose Manuel Cuadra Troncoso** - *Tutor* - [jmcuadra](mailto:jmcuadra@dia.uned.es)


---