FROM java:8
COPY target/welearn-be-0.0.1-SNAPSHOT.jar /usr/share/welearn-be/welearn-be.jar
EXPOSE 8080
HEALTHCHECK CMD curl http://127.0.0.1:8080/api/ping
CMD ["java", "-jar", "/usr/share/welearn-be/welearn-be.jar"]
