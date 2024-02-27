FROM openjdk:21
COPY ./build/libs/LunchReservationServer-0.1-all.jar app.jar
EXPOSE 8080:8080
CMD ["java", "-jar", "app.jar"]