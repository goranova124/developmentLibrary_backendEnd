FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

ARG JAR_FILE
COPY /build/libs/${JAR_FILE} untitled.jar

ENTRYPOINT ["java", "-jar", "/untitled.jar"]
#C:\Users\Denitsa.Goranova\Downloads\123332111\DPortalBackend\untitled\build\libs\untitled.jar