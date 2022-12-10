FROM gradle:7.5.1-jdk17-alpine AS build

LABEL CREATOR = "Дараган Федор"
LABEL GROUP = "ИКБО-10-19"

RUN apk update && apk add wget

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN wget -O mirea.png https://www.mirea.ru/upload/medialibrary/80f/MIREA_Gerb_Colour.png && \
    mv mirea.png app/src/main/resources

RUN gradle clean build
ONBUILD RUN echo "Сборка и запуск произведены. Автор: ${CREATOR}:${GROUP}"

FROM openjdk:20-slim as prod

RUN mkdir /app

COPY --from=build /home/gradle/src/app/build/libs/app.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "-Dspring.profiles.active=prod", "/app/spring-boot-application.jar"]
