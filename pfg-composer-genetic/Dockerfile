# Build pfg-composer-genetic
FROM maven:3.8.1-jdk-11

COPY ./pfg-composer-genetic /app/pfg/pfg-composer-genetic
COPY ./pfg-commons /app/pfg/pfg-commons

WORKDIR /app/pfg
RUN cd /app/pfg/pfg-commons && mvn install
RUN cd /app/pfg/pfg-composer-genetic && mvn package -DskipTests

# Run pfg-composer-genetic
FROM openjdk:11-jre AS pfg-composer-genetic
RUN apt-get update && apt-get install -y musescore
ENV QT_QPA_PLATFORM=offscreen
WORKDIR /app
COPY --from=0 /app/pfg/pfg-composer-genetic/target/pfg-composer-genetic.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]