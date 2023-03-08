FROM amazoncorretto:11-alpine-jdk 
MAINTAINER k-rito 
COPY target/portfolioweb-0.0.1-SNAPSHOT.jar  portfolioweb-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/portfolioweb-0.0.1-SNAPSHOT.jar"] 
