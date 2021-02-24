# Download pfg-core and pfg-backend
FROM alpine/git
WORKDIR /app
RUN git clone https://JaviOlmoI:0b2b13ca3426515ce8de94229b470eb4543ea1c9@github.com/JaviOlmoI/pfg-core.git
RUN git clone https://JaviOlmoI:0b2b13ca3426515ce8de94229b470eb4543ea1c9@github.com/JaviOlmoI/pfg-backend.git

#Install pfg-core and package pfg-backend
FROM maven:3.5-jdk-8-alpine
COPY --from=0 /app/pfg-core /app/dependencies/pfg-core
COPY --from=0 /app/pfg-backend /app/pfg-backend
RUN cd /app/dependencies/pfg-core && mvn install -DskipTests
RUN cd /app/pfg-backend && mvn package -DskipTests

#Run pfg-backend
FROM openjdk:8-jre AS pfg-backend
WORKDIR /app
COPY --from=1 /app/pfg-backend/target/pfg-web-service.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 3000

