FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

ARG JAR_FILE
COPY build/libs/${JAR_FILE} untitled.jar
COPY src/main/resource/DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API.xml /src/main/resource/
COPY src/main/resource/DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_ERROR_CODES.xml /src/main/resource/
COPY src/main/resource/DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_FEATURES.xml /src/main/resource/
COPY src/main/resource/DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_LANGUAGES.xml /src/main/resource/
COPY src/main/resource/DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_REQUEST_PARAMETERS.xml /src/main/resource/
COPY src/main/resource/DAF_TEST_DB.CONNECT_DEUTSCHETELECOM.GCS_DEV_LIBRARY_API_RESPONSE_PARAMETERS.xml /src/main/resource/

ENTRYPOINT ["java", "-jar", "/untitled.jar"]
