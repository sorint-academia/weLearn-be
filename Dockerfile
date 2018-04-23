FROM java:8
COPY target/welearn-be-0.0.1-SNAPSHOT.jar /usr/share/welearn-be/welearn-be.jar
EXPOSE 8080
CMD ["java", "-jar", "/usr/share/welearn-be/welearn-be.jar"]