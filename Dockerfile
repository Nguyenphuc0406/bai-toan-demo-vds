FROM adoptopenjdk/openjdk11:jre11u-ubuntu-nightly
RUN mkdir /opt/app
EXPOSE 8082
COPY target/demo-0.0.1-SNAPSHOT.jar /opt/app
ENTRYPOINT ["java","-jar","/opt/app/demo-0.0.1-SNAPSHOT.jar"]