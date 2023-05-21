FROM mysql:latest

RUN chown -R mysql:root /var/lib/mysql/

ENV MYSQL_DATABASE=$MYSQL_DATABASE
ENV MYSQL_USER=$MYSQL_USER
ENV MYSQL_PASSWORD=$MYSQL_PASSWORD
ENV MYSQL_ROOT_PASSWORD=$MYSQL_ROOT_PASSWORD

ADD data.sql /docker-entrypoint-initdb.d

EXPOSE 3306

# Copy wait-for-it script and make it executable
#ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh

FROM gradle:latest AS build

WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY src ./src

RUN gradle clean build --no-daemon

#FROM openjdk:17-oracle
#
#WORKDIR /app
#COPY --from=build /app/build/libs/*.jar app.jar
#
#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]
#

FROM eclipse-temurin:17-alpine

COPY build/libs/Project-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080/tcp

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-Djdk.util.jar.enableMultiRelease=false", "-jar", "app.jar"]
