DOCKER_TAG=registry.cn-hangzhou.aliyuncs.com/jin82/k8s-rest:1.0
mvn -f ../pom.xml clean package && \
cp ../target/*.jar ./ && \
docker build -t ${DOCKER_TAG} . && \
docker push ${DOCKER_TAG}