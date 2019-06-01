FROM openjdk:8-jdk-alpine
MAINTAINER jin820100449@qq.com
ENV TZ=Asia/Shanghai
ENV APP_PROFILE="prod"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir /application && \
    mkdir /application/log && \
    mkdir /application/config
WORKDIR /application
COPY k8s-kv-*.jar /application/k8s-kv.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /application/k8s-kv.jar --spring.profiles.active=$APP_PROFILE -Dfile.encoding=utf-8"]
EXPOSE 7070