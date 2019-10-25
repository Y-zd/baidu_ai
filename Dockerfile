From hub.c.163.com/library/java:8-jre
ADD target/*.jar baiduai-1.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "baiduai-1.0-SNAPSHOT.jar"]