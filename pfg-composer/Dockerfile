# Download pfg-core
FROM alpine/git
WORKDIR /app
RUN git clone https://JaviOlmoI:0b2b13ca3426515ce8de94229b470eb4543ea1c9@github.com/JaviOlmoI/pfg-core.git
RUN git clone https://JaviOlmoI:0b2b13ca3426515ce8de94229b470eb4543ea1c9@github.com/JaviOlmoI/pfg-composer.git

#Install pfg-core and package pfg-composer
FROM maven:3.5-jdk-8-alpine
WORKDIR /app
COPY --from=0 /app/pfg-core /app/dependencies/pfg-core
COPY --from=0 /app/pfg-composer /app/pfg-composer
RUN cd /app/dependencies/pfg-core && mvn install -DskipTests
RUN cd /app/pfg-composer && mvn package -DskipTests

#Run pfg-composer
FROM openjdk:8-jre AS pfg-composer
WORKDIR /app
COPY --from=1 /app/pfg-composer/target/pfg-composer.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]