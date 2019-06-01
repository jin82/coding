DOCKER_TAG=registry.cn-hangzhou.aliyuncs.com/jin82/k8s-job
mvn -f ../pom.xml clean package && \
cp ../target/*.jar ./ && \
docker build -t ${DOCKER_TAG}:latest . && \
docker push ${DOCKER_TAG}:latest