#FROM ubi9/openjdk-11-runtime
FROM registry.access.redhat.com/ubi9/openjdk-11-runtime
EXPOSE 8443
COPY target/petstore-1.0.0.jar petstore.jar
ENTRYPOINT ["java","-jar","/home/default/petstore.jar"]