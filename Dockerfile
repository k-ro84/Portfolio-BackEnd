FROM amazoncorretto:11-alpine-jdk //de que imagen partimos
MAINTAINER k-rito //dueño de la imagen
COPY target/portfolioweb-0.0.1-SNAPSHOT.jar  portfolioweb-0.0.1-SNAPSHOT.jar //copia empaquetado github
ENTRYPOINT ["java","-jar","/portfolioweb-0.0.1-SNAPSHOT.jar"] //instruccion que se ejecuta primero
