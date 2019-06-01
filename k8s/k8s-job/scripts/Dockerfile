FROM openjdk:8-jdk-alpine
MAINTAINER jin820100449@qq.com
ENV TZ=Asia/Shanghai
ENV APP_PROFILE="prod"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir /application
WORKDIR /application
COPY k8s-job-*.jar /application/k8s-job.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /application/k8s-job.jar"]
