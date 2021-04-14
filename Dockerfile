FROM openjdk:11.0.9
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY build/libs/*.jar home/spring/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/spring/application.jar"]