FROM openjdk:11.0.13-slim
ARG JAR_FILE=build/libs/axon-shoppingmall-compensation-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]