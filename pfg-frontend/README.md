#   PFG Frontend

##  1. Introducción

##  2. Desarrollo local
`npm install` (descargar e instalar dependencias)  
`ng serve` (iniciar servidor local en puerto 4200)  

##  3. Variables de entorno
No se ha encontrado una solución ideal para implementar en Angular. Finalmente se ha decidido mantener los archivos 
originales bajo el directorio `src/environments` para declarar estas variables durante el desarrollo en local, y además 
se han creado dos scripts que se encuentran en `src/assets/env` y se ejecutarán en el index.html teniendo efecto sólo en 
producción, que se encargarán de sobreescribir estas variables con los valores definidos en el contenedor a través de 
los archivos "docker-compose".

De este modo, se deberá tener en cuenta que:

* **Para modificar valores** por defecto o valores en desarrollo local, modificar los archivos de `src/environments`
* **Para crear nuevas variables** se deben crear en primer lugar en `src/environments` y luego definir cómo 
reemplazarlas en `src/assets/env`

## 4. Lanzar nueva versión
* Incluir novedades en `home.component.html`
* Incrementar versión en `src/environments/environment.prod.ts`
* Incrementar version en `package.json`

