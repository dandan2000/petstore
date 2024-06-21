FROM ubi9/openjdk-11-runtime
COPY target/petstore-1.0.0.jar petstore.jar
ENTRYPOINT ["java","-jar","/home/default/petstore.jar"]