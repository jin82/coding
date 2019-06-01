DOCKER_TAG=registry.cn-hangzhou.aliyuncs.com/jin82/k8s-log-client
mvn -f ../pom.xml -DskipTests clean package && \
cp ../target/*.jar ./ && \
docker build -t ${DOCKER_TAG}:latest . && \
docker push ${DOCKER_TAG}:latest