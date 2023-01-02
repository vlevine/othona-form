FROM adoptopenjdk/openjdk11:alpine-jre
COPY ./build/libs/othona-form*.jar /opt/lib/othona-form.jar
ENTRYPOINT ["java"]
CMD ["-Xmx256M", "-jar", "-Dspring.profiles.active=kube", "/opt/lib/othona-form.jar"]
